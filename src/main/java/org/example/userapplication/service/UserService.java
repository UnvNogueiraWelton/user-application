package org.example.userapplication.service;

import org.example.userapplication.dto.UserDTO;
import org.example.userapplication.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class UserService {
    private final List<User> users;

    public UserService() {
        this.users = new ArrayList<>();
    }

    public User createUser(UserDTO data) throws ResponseStatusException {
        User user = new User(
                this.users.size(),
                data.getName(),
                data.getEmail(),
                data.getAge(),
                new Date(),
                new Date(),
                null
        );

        users.add(user);

        return user;
    }

    public User editUser(Integer id, UserDTO data) {
        User user = this.findUserById(id);

        user.setName(data.getName());
        user.setEmail(data.getEmail());
        user.setAge(data.getAge());

        user.setUpdatedAt(new Date());
        return user;
    }

    public User deleteUser(Integer id) {
        User user = this.findUserById(id);

        user.setDeletedAt(new Date());

        return user;
    }

    public User findUserById(Integer id) throws ResponseStatusException {
        Optional<User> user = this.users.stream().filter(u -> Objects.equals(u.getId(), id)).findFirst();

        if(user.isEmpty() || user.get().getDeletedAt() != null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User Not Found");
        }

        return user.get();
    }

    public List<User> findAll() {
        return this.users.stream().filter(user -> user.getDeletedAt() == null).toList();
    }
}

