<H3>Kafka java example to understand how it works</H3>

In this project we use Image ([bitnami-kafka](https://hub.docker.com/r/bitnami/kafka))

Dependencies in producer and consumer of kafka are next:
```xml
        <dependency>
            <groupId>org.apache.kafka</groupId>
            <artifactId>kafka-clients</artifactId>
            <version>3.5.1</version>
            <scope>compile</scope>
        </dependency>
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-api</artifactId>
            <version>2.0.7</version>
        </dependency>
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-simple</artifactId>
            <version>2.0.7</version>
        </dependency>
```

<H4>To adjust kafka:</H4>

For kafka settings in mode Kraft necessary put keys:
```yaml
- KAFKA_CFG_NODE_ID=0
- KAFKA_CFG_PROCESS_ROLES=controller,broker
- KAFKA_CFG_CONTROLLER_QUORUM_VOTERS=0@localhost:9093
```

Others:
```yaml
- KAFKA_CFG_LISTENERS=PLAINTEXT://:9092,CONTROLLER://:9093,EXTERNAL://:9094
- KAFKA_CFG_ADVERTISED_LISTENERS=PLAINTEXT://kafka:9092,EXTERNAL://localhost:9094
- KAFKA_CFG_LISTENER_SECURITY_PROTOCOL_MAP=CONTROLLER:PLAINTEXT,EXTERNAL:PLAINTEXT,PLAINTEXT:PLAINTEXT
- KAFKA_CFG_CONTROLLER_LISTENER_NAMES=CONTROLLER
```

from SecurityProtocol you can find:\
PLAINTEXT - Un-authenticated, non-encrypted channel\
SASL_PLAINTEXT - SASL authenticated, non-encrypted channel\
SASL_SSL - SASL authenticated, SSL channel\
SSL - SSL channel

to write topic to kafka you have to run next line in CLI of kafka:
```
/opt/bitnami/kafka/bin/kafka-topics.sh --bootstrap-server localhost:9094 --create --if-not-exists --topic myTopic1 --replication-factor 1 --partitions 1
```