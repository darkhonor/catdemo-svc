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
package com.darkhonor.springdemo.model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import org.hibernate.validator.constraints.NotBlank;

/**
 * A simple POJO to use in the example service.  Who doesn't like cats?
 * 
 * @author Alex Ackerman <aackerman@darkhonor.com>
 */
@Entity
public class Cat {

    @Id
    private Long mId;
    @NotBlank
    private String mName;
    private String mColor;

    private Cat() {
    }

    public Cat(String name, String color) {
        mName = name;
        mColor = color;
    }

    public Long getId() {
        return mId;
    }

    public Cat setId(Long id) {
        this.mId = id;
        return this;
    }

    public String getName() {
        return mName;
    }

    public Cat setName(String name) {
        this.mName = name;
        return this;
    }

    public String getColor() {
        return mColor;
    }

    public Cat setColor(String color) {
        this.mColor = color;
        return this;
    }
    
    @Override
    public String toString() {
        return this.mName + " is a " + this.mColor + " cat.";
    }
}
