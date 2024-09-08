package com.neckcode.services;

import com.neckcode.common.DataSerializer;
import com.neckcode.dto.User;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.UUID;

import static com.neckcode.data.UserData.USERS;

public class ProducerExample {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9094");
        props.put("key.serializer", "org.apache.kafka.common.serialization.UUIDSerializer");
        props.put("value.serializer", DataSerializer.class.getName());
        KafkaProducer<UUID, User> producer = new KafkaProducer<>(props);
        for (User user : USERS) {
            producer.send(
                    new ProducerRecord<>("myTopic1", user.getId(), user));
        }
        producer.close();
    }
}