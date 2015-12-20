# OpenHabbo
OpenHabbo is a distributed Habbo Hotel private server written in Java & NodeJS. The idea behind the project is to create a server architecture similar to the official servers. Each component of the server would be on its own micro-service. 

The microservices communicate with each other using HTTP. Each microservice would be connected to a main service to monitor health, logging etc.

The implementation of the Habbo protocol is currently only added as a placeholder, none of that stuff is final.
