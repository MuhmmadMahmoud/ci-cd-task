# CI CD Task

Simple Spring Boot project with a GitHub Actions pipeline.

## Endpoints

- `/` returns a hello message
- `/hello?name=Muhmmad` returns Hello Muhmmad !
- `/add?a=2&b=3` returns the result is 5

## Run it

```
mvn clean package
java -jar target/demo-0.0.1-SNAPSHOT.jar
```

Then open http://localhost:8080

## Pipeline stages

1. validate - runs `mvn validate` to check the project quickly
2. build_test - runs the tests, builds the jar, uploads the jar and the test reports
3. dockerfile_lint - runs Hadolint on the Dockerfile, fails if there is a problem
4. docker_publish_staging - only on main, downloads the jar and pushes the image to GHCR

## Image

```
docker pull ghcr.io/muhmmadmahmoud/ci-cd-task:staging
```
