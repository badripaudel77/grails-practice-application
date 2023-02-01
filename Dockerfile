# Declare Base Image, latest version of Ubuntu, a complete OS it will be
# It's for demo or learning purpose. In production ready app, it's best to choose nearest base Image such as gradle image ...
FROM ubuntu:latest

# Set required Versions as environment
ENV GRAILS_VERSION 3.3.8
ENV GRADLE_VERSION 4.0
ENV JAVA_VERSION 8

# Update package lists and install curl, zip, unzip and bash
RUN apt-get update && apt-get install -y zip curl unzip bash wget

# 1. Install Java[openjdk java-8] and add JAVA_HOME and set path correctly.
RUN apt-get update && apt-get install -y openjdk-$JAVA_VERSION-jdk

ENV JAVA_HOME /usr/lib/jvm/java-$JAVA_VERSION-openjdk-amd64
ENV PATH $JAVA_HOME/bin:$PATH

# 2. Download Gradle 4.0 and add GRADLE_HOME and set path.
RUN wget https://downloads.gradle-dn.com/distributions/gradle-$GRADLE_VERSION-bin.zip
RUN unzip gradle-$GRADLE_VERSION-bin.zip
RUN rm gradle-$GRADLE_VERSION-bin.zip

ENV GRADLE_HOME /gradle-$GRADLE_VERSION
ENV PATH $GRADLE_HOME/bin:$PATH

# 3. Install Grails and add env variables with

RUN wget https://github.com/grails/grails-core/releases/download/v$GRAILS_VERSION/grails-$GRAILS_VERSION.zip
RUN unzip grails-$GRAILS_VERSION.zip
RUN rm -rf grails-$GRAILS_VERSION.zip
RUN ln -s grails-$GRAILS_VERSION grailS

ENV GRAILS_HOME /grails-$GRAILS_VERSION
# Set this directory in the path
ENV PATH $GRAILS_HOME/bin:$PATH

# copy everything in the current directory in the host machine to the current directory in the image
WORKDIR /app
COPY . /app

# Build WAR file as the war file is a standard format for packaging and deploying Java web applications.
#RUN grails war

# Name of the app is grails_application and version is 0.1 [from build.gradle file] and will be located in target directory
# When the container is started, this command will run the war file with an embedded Tomcat server,
# And the application will be accessible on port 8080 (or any other port that you have exposed while running the container).
#CMD ["java", "-jar", "target/grails_application-0.1.war"]

# start app
CMD ["grails", "run-app"]