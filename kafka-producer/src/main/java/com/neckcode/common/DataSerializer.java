package com.neckcode.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neckcode.dto.User;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serializer;

import java.io.IOException;

public class DataSerializer implements Serializer<User> {
        @Override
        public byte[] serialize(String topic, User user) {
            try {
                ObjectMapper mapper = new ObjectMapper();
                return mapper.writeValueAsBytes(user);
            } catch (IOException e) {
                throw new RuntimeException("Error deserializing", e);
            }
        }
    }
