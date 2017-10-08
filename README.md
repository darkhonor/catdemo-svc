Demonstration of Spring Boot w/Google AppEngine, Datastore
=========================
[![Build Status](https://travis-ci.org/darkhonor/catdemo-svc.svg?branch=master)](https://travis-ci.org/darkhonor/catdemo-svc)

This is one part of three services created to demonstrate how to have a 
microservice using SpringBoot hosted on Google's AppEngine delivering 
authenticated content via RESTful services.

This is based upon code and discussion consolidated from numerous sources:

* [SpringBoot HelloWorld for App Engine Standard (Java 8)](https://github.com/GoogleCloudPlatform/getting-started-java/tree/master/appengine-standard-java8/springboot-appengine-standard)
* [Google Cloud Datastore - Spring Boot Sample](https://github.com/o/spring-boot-google-cloud-datastore-sample)
* [Spring Data on GAE - Part 1 - Basic JPA](http://tommysiu.blogspot.kr/2014/01/spring-data-on-gae-part-1.html)

Prerequisites:
* [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
* [AppEngine Standard Environment](https://cloud.google.com/appengine/) (Java 8)
* [Maven](https://maven.apache.org/download.cgi) (at least 3.5)
* [Google Cloud SDK](https://cloud.google.com/sdk/)

Run locally:
   
    mvn appengine:start

Building:

    mvn clean package

Deploying:

    mvn appengine:deploy

### License

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.