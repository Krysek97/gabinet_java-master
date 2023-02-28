package com.gabinet.gabinet.security.securityUser.user;

import com.gabinet.gabinet.security.securityUser.user.SecurityUser;
import com.gabinet.gabinet.security.securityUser.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/add")
    public SecurityUser add(@RequestBody SecurityUser user) {
        return userService.addUser(user);
    }

    @GetMapping("/all")
    public List<SecurityUser> all() {
        return userService.all();
    }

    @GetMapping("/get/{id}")
    public Optional<SecurityUser> byId(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping("/logged")
    public SecurityUser findByToken(@RequestBody String token) {
        return userService.findByToken(token);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        userService.delete(id);
    }

}
