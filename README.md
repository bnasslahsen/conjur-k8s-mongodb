# Demo project for Conjur integration with OpenShift/Kubernetes
A demo application creating using the Spring Framework. 
This application requires access to an H2 database.

- [Pre-requisites](#pre-requisites)
- [Docker images](#docker-images)
  * [Images in dockerhub](#images-in-dockerhub)
  * [Building the Docker images (optional)](#building-the-docker-images--optional-)

## Pre-requisites
- OS Linux / MacOS
- podman / docker
- Java 11

## Docker images

### Building the Docker images 
If you don't have access to dockerhub and you need to build the images then, after cloning this repository:

1. Build the `conjur-k8s-mongodb`

```shell
./mvnw clean package
# or with podman run -it --rm -v $HOME/.m2:/root/.m2 -v "$(pwd)":/build -w /build maven mvn clean package
podman build --arch=amd64 -f docker/initial/Dockerfile -t conjur-k8s-mongodb .
```

2. Build the `conjur-k8s-mongodb-summon-demo`

```shell
./mvnw clean package
podman build --arch=amd64 -f docker/summon/Dockerfile -t conjur-k8s-mongodb-summon-demo .
```

3. For Native Builds

```shell
mvn -Pnative clean spring-boot:build-image
docker run -d --rm -p 8080:8080 -e MONGODB_URI='mongodb://ip-10-0-9-181.eu-west-2.compute.internal:27017/admin' conjur-k8s-mongodb:2.0
```

4. For Native Builds

```shell
podman  build  --arch=amd64  -t run:small-cnb .
podman tag run:small-cnb  docker.io/bnasslahsen/run:small-cnb
podman push docker.io/bnasslahsen/run:small-cnb
```