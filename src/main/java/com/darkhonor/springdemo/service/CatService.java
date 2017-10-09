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
package com.darkhonor.springdemo.service;

import com.darkhonor.springdemo.model.Cat;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.KeyFactory;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alex Ackerman <aackerman@darkhonor.com>
 */
@Service
public class CatService {

    private final Logger log = LoggerFactory.getLogger(CatService.class);

    @Autowired
    Datastore datastore;

    private KeyFactory mCatKeyFactory;

    @PostConstruct
    public void initializeKeyFactories() {
        log.info("Initializing key factories");
        this.mCatKeyFactory = datastore.newKeyFactory().setKind("Cat");
    }

    public Entity createCat(Cat cat) {
        return datastore.put(createCatEntity(cat));
    }

    private Entity createCatEntity(Cat cat) {
        Key key = this.mCatKeyFactory.newKey(cat.getId().toString());
        return Entity.newBuilder(key)
                .set("name", cat.getName())
                .set("color", cat.getColor())
                .build();
    }

    public List<Cat> getAllCats() {
        List<Cat> cats = new ArrayList<>();
        Query<Entity> query = Query.newEntityQueryBuilder().setKind("Cat").build();
        QueryResults<Entity> results = datastore.run(query);

        Builder<Cat> resultListBuilder = ImmutableList.builder();
        while (results.hasNext()) {
            resultListBuilder.add(new Cat(results.next()));
        }

        return resultListBuilder.build();
    }

    @Async
    public void updateCat(Long id, Cat cat) {
        // TODO: Need to write updateCat method
    }

    @Async
    public void deleteCat(Long id) {
        // TODO: Need to write deleteCat method
    }
}
