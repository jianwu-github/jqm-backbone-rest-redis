jqm-backbone-rest-redis
=======================

This is a Backbone.js + jQuery Mobile Demo Application ported from github repository [backbone-jax-cellar](https://github.com/ccoenraets/backbone-jax-cellar)

This demo application has three parts:

1. Back-end is a local Redis Server running on default port 6379, Wine data is loaded into redis server with python script wineloader.py using [redis-py](https://github.com/andymccurdy/redis-py)

2. A Java RESTful WS Server built with Jersey JAX-RS and Gradle, you can build "jqm-backbone-rest-redis.war" by running "gradle build" and deploy to a Tomcat 7 Web Container

3. JQuery Mobile + Backbone.js as Front-end to show Wine by consuming RESTful Wine List APIs



