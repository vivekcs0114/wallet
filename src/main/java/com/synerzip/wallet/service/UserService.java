package com.synerzip.wallet.service;

import com.synerzip.wallet.model.User;
import com.synerzip.wallet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(User user) {
        return userRepository.save(user);
    }

    public User find(int id) {
        return userRepository.findById(id);
    }
}
