FROM azul/zulu-openjdk:8
MAINTAINER Edgardo Cruz <edgardo1230@gmail.com>, https://github.com/edgardo1230/xxx.git

VOLUME /logs

ENV USER_NAME registry
ENV APP_HOME /opt/raziem-cloud/$USER_NAME

RUN \
  useradd -ms /bin/bash $USER_NAME && \
  mkdir -p $APP_HOME

ADD target/$USER_NAME.jar ${APP_HOME}/app.jar

RUN \
  chown $USER_NAME $APP_HOME/app.jar && \
  bash -c 'touch ${APP_HOME}/app.jar'
  
ENV JAVA_TOOL_OPTIONS "-Xms256M -Xmx256M -Djava.awt.headless=true -Djava.security.egd=file:/dev/./urandom"

USER $USER_NAME
WORKDIR $APP_HOME

ENTRYPOINT ["java","-jar","app.jar"]
