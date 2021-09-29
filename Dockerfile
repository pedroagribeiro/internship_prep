FROM "ubuntu:21.04"

# Install necessary packages
RUN apt update && apt -y upgrade
RUN apt -y install wget
RUN apt -y install git
RUN apt -y install maven

# Clone the repository
RUN git clone https://github.com/pedroagribeiro/internship_prep.git

WORKDIR /internship_prep/simple_api
RUN mvn compile
RUN mvn package

RUN java -jar target/simple_api-0.0.1-SNAPSHOT.jar

CMD tail -f /dev/null
