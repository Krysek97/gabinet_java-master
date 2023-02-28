package com.gabinet.gabinet.security.securityUser.user;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public SecurityUser addUser(SecurityUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("USER");
        return userRepository.save(user);
    }

    public List<SecurityUser> all() {
        return userRepository.findAll();
    }

    public Optional<SecurityUser> findById(Long id) {
        return userRepository.findById(id);
    }

    public SecurityUser findByToken(String token) {
        JSONObject json = new JSONObject(token);
        return userRepository.findByToken(json.getString("token"));
    }

    public SecurityUser findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public void save(SecurityUser user) {
        userRepository.save(user);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }


}
