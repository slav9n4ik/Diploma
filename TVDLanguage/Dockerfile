FROM oracle/graalvm-ce:latest

RUN mkdir TVDLanguage
VOLUME /TVDLanguage

RUN yum install maven -y

# Define working directory.
WORKDIR /root

# Define default command.
CMD bash -sh