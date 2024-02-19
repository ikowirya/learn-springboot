package com.learning.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.learning.demo.model.User;

@Repository
public class UserRepository {
    private final List<User> users = new ArrayList<>();

    public User save(User user) {
        user.setId((long) users.size() +1);
        users.add(user);
        return user;
    }

    public Optional<User> findById(Long id) {
        return users.stream()
        .filter(user -> user.getId().equals(id))
        .findFirst();
    }
}
