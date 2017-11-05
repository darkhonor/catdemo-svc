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
import com.googlecode.objectify.Key;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import java.util.List;
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
    private ObjectifyFactory objectifyFactory;

    public Key<Cat> createCat(Cat cat) {
        Objectify ofy = this.objectifyFactory.begin();
        return ofy.save().entity(cat).now();
    }

    public List<Cat> getAllCats() {
        Objectify ofy = this.objectifyFactory.begin();
        List<Cat> results = ofy.load().type(Cat.class).list();
        log.debug("Number of Cats Returned: " + results.size());
        return results;
    }

    @Async
    public void updateCat(Long id, Cat cat) {
        // TODO: Need to write updateCat method
    }

    @Async
    public void deleteCat(Long id) {
        // TODO: Need to write deleteCat method
    }

    public int getCount() {
        Objectify ofy = this.objectifyFactory.begin();
        return ofy.load().type(Cat.class).count();
    }

    public void initialize() {

        Cat newCat = new Cat("Fluffy", "White");
        log.debug("Initializing DB with Fluffy: " + newCat);
        Key<Cat> key = this.createCat(newCat);
        log.debug("Cat saved to the databse.  Key: " + key);
    }
}
