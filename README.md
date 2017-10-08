Demonstration of Spring Boot w/Google AppEngine, Datastore
=========================

This is one part of three services created to demonstrate how to have a 
microservice using SpringBoot hosted on Google's AppEngine delivering 
authenticated content via RESTful services.

This is based upon code consolidated form numerous sources:

* https://github.com/GoogleCloudPlatform/getting-started-java/tree/master/appengine-standard-java8/springboot-appengine-standard
* https://github.com/o/spring-boot-google-cloud-datastore-sample

Prerequisites:
* [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
* [AppEngine Standard Environment](https://cloud.google.com/appengine/) (Java 8)
* [Maven](https://maven.apache.org/download.cgi) (at least 3.5)
* [Google Cloud SDK](https://cloud.google.com/sdk/)

Run locally:
   
    `mvn appengine:start`

Building:

    `mvn clean package`

Deploying:

    `mvn appengine:deploy`

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