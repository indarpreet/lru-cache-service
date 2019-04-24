# lru-cache-service
1. The above project is based on least recently used implementation.
2. This is a spring boot application uses spring web mvc technology.
3. pom.xml contains all the dependency require to start the application
4. Controller package contains SpringBootWebApplication.java which contains main method from where we can start
   the application by running or debugging it as a java application.
5. In application.properties the application is defined to run on port 8080 and with context path /lrucache.
6. For Testing use below two URL's
   - http://localhost:8080/lrucache/api/v1/put/1
   - http://localhost:8080/lrucache/api/v1/get/1
