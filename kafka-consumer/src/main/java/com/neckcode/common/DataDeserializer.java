package com.neckcode.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neckcode.dto.User;
import lombok.NoArgsConstructor;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;

public class DataDeserializer implements Deserializer<User> {
        @Override
        public User deserialize(String topic, byte[] data) {
            try {
                ObjectMapper mapper = new ObjectMapper();
                return mapper.readValue(data, User.class);
            } catch (IOException e) {
                throw new RuntimeException("Error deserializing", e);
            }
        }
    }
