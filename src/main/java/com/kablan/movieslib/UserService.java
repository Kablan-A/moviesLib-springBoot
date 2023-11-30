package com.kablan.movieslib;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Optional<User> singleUser(String eMail) {
        return userRepository.findUserByEMail(eMail);
    }

}
