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
package com.darkhonor.springdemo.controller;

//import java.util.List;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
import com.darkhonor.springdemo.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
//import static org.springframework.web.bind.annotation.RequestMethod.POST;
//import static org.springframework.web.bind.annotation.RequestMethod.PUT;

/**
 *
 * @author Alex Ackerman <aackerman@darkhonor.com>
 */
@RestController
//@RequestMapping("/")
public class CatController {

    @Autowired
    CatService catService;
    
    @GetMapping("/")
    public String hello() {
        return "Hello.  I like cats";
    }
//    @RequestMapping(value = "/hello", method = GET)
//    public String hello() {
//        return "Hello.  I like cats";
//    }
//    
//    @RequestMapping(method = GET)
//    public List<Object> list() {
//        return null;
//    }
//    
//    @RequestMapping(value = "/{id}", method = GET)
//    public Object get(@PathVariable String id) {
//        return null;
//    }
//    
//    @RequestMapping(value = "/{id}", method = PUT)
//    public ResponseEntity<?> put(@PathVariable String id, @RequestBody Object input) {
//        return null;
//    }
//    
//    @RequestMapping(value = "/{id}", method = POST)
//    public ResponseEntity<?> post(@PathVariable String id, @RequestBody Object input) {
//        return null;
//    }
//    
//    @RequestMapping(value = "/{id}", method = DELETE)
//    public ResponseEntity<Object> delete(@PathVariable String id) {
//        return null;
//    }

}
