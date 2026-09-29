package com.github.FranciscoLopes8.cooperari.service;

import com.github.FranciscoLopes8.cooperari.model.User;
import com.github.FranciscoLopes8.cooperari.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }


    public boolean CreateAccount(String name, String email, String password, HttpSession session){
        User user = new User();

        user.setName(name);
        user.setEmail(email);
        String encode = passwordEncoder.encode(password);
        user.setPassword(encode);

        try {
            userRepository.save(user);
            session.setAttribute("user", user);
            return true;
        }
        catch (Exception e){
            System.out.println(e);
        }

        return false;
    }

    public boolean ValidateCredentials(String email, String password, HttpSession session){
        Optional<User> userEmail = userRepository.findByEmail(email);

        if (userEmail.isEmpty()) return false;

        User user = userEmail.get();
        if (passwordEncoder.matches(password, user.getPassword())){
            session.setAttribute("user", user);
            return true;
        }
        else return false;
    }

}
