# console-exercise

To be able to run this application locally, it is neccesary to install: 

 - [docker-compose](https://docs.docker.com/compose/install/) 
 - [Java 8](https://java.com/en/download/help/download_options.xml)
 - [Maven](https://maven.apache.org/) 

The recommended IDEA is [IntelliJ](https://www.jetbrains.com/idea/).

Enter project, navigate to the project root folder and run `docker-compose up -d`. This command will download docker images described in **docker-compose.yml** file and run corresponding containers. To stop and remove containers, type in `docker-compose down`.

To check your database, run `localhost:8081` in your browser and type in database credentials written in docker-compose.yml file.

Run the application and follow the instructions in the console.
