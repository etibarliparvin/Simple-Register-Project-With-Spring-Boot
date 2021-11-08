package com.example.simpleregister.business.abstracts;


import com.example.simpleregister.entity.User;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserService {

    void add(User user);

    List<User> findAll();

  Optional<User> findUserByEmailAndPassword(String email, String password);

}
