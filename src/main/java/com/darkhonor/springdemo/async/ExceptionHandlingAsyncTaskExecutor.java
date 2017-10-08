/*
 * Copyright 2011-2017 Darkhonor Development.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.darkhonor.springdemo.async;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.task.AsyncTaskExecutor;

/**
 *
 * @author Alex Ackerman <aackerman@darkhonor.com>
 */
public class ExceptionHandlingAsyncTaskExecutor implements AsyncTaskExecutor,
        InitializingBean, DisposableBean {

    private final Logger log = LoggerFactory.getLogger(ExceptionHandlingAsyncTaskExecutor.class);
    private final AsyncTaskExecutor mExecutor;
    
    public ExceptionHandlingAsyncTaskExecutor(AsyncTaskExecutor executor) {
        this.mExecutor = executor;
    }
    
    @Override
    public void execute(Runnable task, long startTimeout) {
        mExecutor.execute(createWrappedRunnable(task), startTimeout);
    }

    @Override
    public Future<?> submit(Runnable task) {
        return mExecutor.submit(createWrappedRunnable(task));
    }

    @Override
    public <T> Future<T> submit(Callable<T> task) {
        return mExecutor.submit(createCallable(task));
    }

    @Override
    public void execute(Runnable task) {
        mExecutor.execute(createWrappedRunnable(task));
    }

    private <T> Callable<T> createCallable(final Callable<T> task) {
        return () -> {
            try {
                return task.call();
            } catch (Exception e) {
                handle(e);
                throw e;
            }
        };
    }
    
    private Runnable createWrappedRunnable(final Runnable task) {
        return () -> {
            try {
                task.run();
            } catch (Exception e) {
                handle(e);
            }
        };
    }
    
    protected void handle(Exception e) {
        log.error("Caught async exception", e);
    }
    
    @Override
    public void afterPropertiesSet() throws Exception {
        if (mExecutor instanceof InitializingBean) {
            InitializingBean bean = (InitializingBean) mExecutor;
            bean.afterPropertiesSet();
        }
    }

    @Override
    public void destroy() throws Exception {
        if (mExecutor instanceof DisposableBean) {
        DisposableBean bean = (DisposableBean) mExecutor;
            bean.destroy();
        }
    }
    
}
