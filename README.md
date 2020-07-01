# movie-microservices
This is a sample project used to understand the work of Microservices in Spring, using Eureka Client.

## movie-catalog-service
This is the first micro-service which is basically providing the interaction with the Client. Running at port: 8081, it will aggregate the data using RestTemplate calls
from the Eureka Client to fetch the details from the other two micro-services.

## movie-info-service
This is the second micro-service which is currently providing the catalog details related to a particular "movieId", and basically consumed at the movie-catalog-service which fetches the details for the movies for a specific userId. Running at port: 8082, it will be also running as a Eureka client.

## ratings-data-service
This is the third micro-service which is currently providing the ratings details related to a particular "movieId" depending on the "userId", and basically consumed at the movie-catalog-service which fetches the ratings-info for the movies for a specific userId. Running at port: 8083, it will be also running as a Eureka client.


## discover-server
This is the main Eureka-Server that needs to be run as an independent service which discovers the other microservices, running on different port. The load-balancing is computed at the Client side since this is performing Client-Side service discovery.

> **Update:** Currently, there is no database-mechanism attached to the microservices since it was a plain exercise to understand the utility of Spring in building micro-services that communicate using REST calls.
