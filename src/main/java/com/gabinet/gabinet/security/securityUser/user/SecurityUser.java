package com.gabinet.gabinet.security.securityUser.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import net.bytebuddy.utility.nullability.MaybeNull;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

@Data
@Table(name = "security_user")
@Entity
@AllArgsConstructor
public class SecurityUser  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "role")
    private String role;
    @Column(name = "token")
    @MaybeNull
    private String token = null;

    public SecurityUser() {
    }

    public SecurityUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public SecurityUser(Long id, String username, String password, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public SecurityUser(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

}
