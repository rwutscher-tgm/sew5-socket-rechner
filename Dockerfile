FROM gradle
COPY src/ /app/src
COPY settings.gradle /app/settings.gradle
COPY build.gradle /app/build.gradle
WORKDIR /app
#RUN gradle build --stacktrace