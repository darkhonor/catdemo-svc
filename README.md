Demonstration of Spring Boot w/Google AppEngine, Datastore
=========================
[![Build Status](https://travis-ci.org/darkhonor/catdemo-svc.svg?branch=master)](https://travis-ci.org/darkhonor/catdemo-svc)

This is one part of three services created to demonstrate how to have a 
microservice using SpringBoot hosted on Google's AppEngine delivering 
authenticated content via RESTful services.

UPDATE: This is compiling, but not running properly.  I'm getting a generic 404 error and no way to find out why...

This is based upon code and discussion consolidated from numerous sources:

* [SpringBoot HelloWorld for App Engine Standard (Java 8)](https://github.com/GoogleCloudPlatform/getting-started-java/tree/master/appengine-standard-java8/springboot-appengine-standard)
* [Google Cloud Datastore - Spring Boot Sample](https://github.com/o/spring-boot-google-cloud-datastore-sample)
* [Spring Data on GAE - Part 1 - Basic JPA](http://tommysiu.blogspot.kr/2014/01/spring-data-on-gae-part-1.html)
* [Creating a REST Web Service With Java and Spring](https://dzone.com/articles/creating-a-rest-api-with-java-and-spring) (3 Part Series)

Prerequisites:
* [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
* [AppEngine Standard Environment](https://cloud.google.com/appengine/) (Java 8)
* [Maven](https://maven.apache.org/download.cgi) (at least 3.5)
* [Google Cloud SDK](https://cloud.google.com/sdk/)

### Changes Needed to Build for You
In order to have this example work for you, make the following changes to the downloaded code:

In appengine-web.xml, change the application name to your Google AppEngine project name:
```xml
<application>gae-spring-boot-microsvc</application>
```

In .travis.yml, change the last line of the script block to match your AppEngine project name:
```yml
script:
#  - gcloud version || true
  - if [ ! -d "$HOME/google-cloud-sdk/bin" ]; then rm -rf $HOME/google-cloud-sdk; export CLOUDSDK_CORE_DISABLE_PROMPTS=1; curl https://sdk.cloud.google.com | bash; fi
  # Add gcloud to $PATH
  - source /home/travis/google-cloud-sdk/path.bash.inc
  - gcloud version
  - gcloud config set project gae-spring-boot-microsvc
```

Everything else should work as expected.

### Building
Building:
```
mvn clean package
```

Run locally:
```   
mvn appengine:start
```

Deploying:
```
mvn appengine:deploy
```

### Design
I'm putting this here as a means to share the idea behind this set of projects.  I wanted
to combine some modern technologies in a way that I haven't been able to find on the
Interwebs so far.  So, this will be my contribution and I hope it's helpful to someone.

#### JSON Representation of Model
This service will present information stored in the Datastore as Javascript Object Notation,
or JSON.  A typical JSON response for a Cat will resemble the following:
```json
{
    "id": 12345,
    "name": "Jack",
    "color": "Black"
}
```

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