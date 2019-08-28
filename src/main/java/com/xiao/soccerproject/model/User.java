package com.xiao.soccerproject.model;

import com.fasterxml.jackson.annotation.JsonView;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Users")
public class User {

    public interface DefUserInfo{};
    public interface AdvUserInfo extends DefUserInfo{};

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(DefUserInfo.class)
    private Long id;

    @JsonView(DefUserInfo.class)
    @Column(name = "name")
    private String name;

    @JsonView(AdvUserInfo.class)
    @Column(name = "password")
    private String password;

    @JsonView(AdvUserInfo.class)
    @Column(name = "secret_key")
    private String secretKey;

    @JsonView(DefUserInfo.class)
    @Column(name = "first_name ")
    private String firstName;

    @JsonView(DefUserInfo.class)
    @Column(name = "last_name")
    private String lastName;

    @JsonView(DefUserInfo.class)
    @Column(name = "email")
    private String email;

    @JsonView(AdvUserInfo.class)
    @ManyToMany(cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
    @JoinTable(name = "users_role",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    private List<Role> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = DigestUtils.md5Hex(password.trim());
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public Set<Role> getRoles() {
//        return roles;
//    }

    public List<Role> getRoles(){
        try{
            int size = roles.size();
        }
        catch(Exception e){
            return null;
        }
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return String.format("email: %s, pass: %s", email, password);
    }
}
