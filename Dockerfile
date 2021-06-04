FROM openjdk:8u191-jre-alpine3.8

WORKDIR /usr/share/grsoe

ADD target/grsoe-1.0-SNAPSHOT.jar grsoe-1.0-SNAPSHOT.jar
ADD target/original-grsoe-1.0-SNAPSHOT.jar original-grsoe-1.0-SNAPSHOT.jar
ADD suites suites
ADD src/main/resources/environments.xml environments.xml
ADD src/main/resources/test.properties test.properties
ENTRYPOINT java -DWEBDRIVER_REMOTE_URL=$HUB_HOST \
            -DWEBDRIVER_BROWSER_TYPE=$WEBDRIVER_BROWSER_TYPE \
            -DTEST_ENV=$TEST_ENV \
            -DTEST_SUITES=$TEST_SUITES \
            -DWEBDRIVER_INSTALL=$WEBDRIVER_INSTALL \
            -DWEBDRIVER_HEADLESS=$DWEBDRIVER_HEADLESS \
            -DTEST_PARALLEL_THREADS=$TEST_PARALLEL_THREADS -jar grsoe-1.0-SNAPSHOT.jar

