package com.neckcode.data;

import com.neckcode.dto.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

public class UserData {
    public static final List<User> USERS = new ArrayList<>();

    static {
        var random = new Random();
        for (int i = 0; i < 100; i++) {
            var user = new User();
            user.setId(UUID.randomUUID());
            user.setAge(random.nextInt());
            user.setFirstName(String.format("User_first_name_%s", random.nextInt()));
            user.setLastName(String.format("User_last_name_%s", random.nextInt()));
            user.setEmail(String.format("User_email_%s", random.nextInt()));
            USERS.add(user);
        }
    }
}
