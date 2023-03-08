# demo-camunda
Demo of application with Camunda using Kotlin, Gradle, Spring Boot, Postgres.

## Source
- https://www.baeldung.com/spring-boot-embedded-camunda
- https://github.com/eugenp/tutorials/tree/master/spring-boot-modules/spring-boot-process-automation
- https://docs.camunda.io/docs/components/modeler/desktop-modeler/model-your-first-diagram/

## How to model BPMN
- Use **Camunda Modeler**: https://camunda.com/download/modeler/

## How to run locally
1. Build it
```shell
./gradlew build
```
2. Start dependencies (for example, database)
```shell
docker-compose up -d
```
3. Run the app using gradle's `bootRun` or just run jar file
```shell
./gradlew bootRun
``` 
4. Open http://localhost:8080/camunda/app/welcome/default/#!/welcome
5. Login as `demo`/`demo`
5. Start new process from Tasklist http://localhost:8080/camunda/app/tasklist