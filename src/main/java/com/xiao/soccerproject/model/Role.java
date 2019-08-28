package com.xiao.soccerproject.model;




import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(User.AdvUserInfo.class)
    private Long id;

    @JsonView(User.AdvUserInfo.class)
    @Column(name = "name")
    private String name;

    @JsonView(User.AdvUserInfo.class)
    @Column(name = "allowed_resource")
    private String allowedResource;

    @JsonView(User.AdvUserInfo.class)
    @Column(name = "allowed_read")
    private boolean allowedRead;

    @JsonView(User.AdvUserInfo.class)
    @Column(name= "allowed_create")
    private boolean allowedCreate;

    @JsonView(User.AdvUserInfo.class)
    @Column(name = "allowed_update")
    private boolean allowedUpdate;

    @JsonView(User.AdvUserInfo.class)
    @Column(name = "allowed_delete")
    private boolean allowedDelete;

    @ManyToMany(mappedBy = "roles",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<User> users;

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

    public String getAllowedResource() {
        return allowedResource;
    }

    public void setAllowedResource(String allowedResource) {
        this.allowedResource = allowedResource;
    }

    public boolean isAllowedRead() {
        return allowedRead;
    }

    public void setAllowedRead(boolean allowedRead) {
        this.allowedRead = allowedRead;
    }

    public boolean isAllowedCreate() {
        return allowedCreate;
    }

    public void setAllowedCreate(boolean allowedCreate) {
        this.allowedCreate = allowedCreate;
    }

    public boolean isAllowedUpdate() {
        return allowedUpdate;
    }

    public void setAllowedUpdate(boolean allowedUpdate) {
        this.allowedUpdate = allowedUpdate;
    }

    public boolean isAllowedDelete() {
        return allowedDelete;
    }

    public void setAllowedDelete(boolean allowedDelete) {
        this.allowedDelete = allowedDelete;
    }

    public List<User> getUsers() {
        try {
            int size = users.size();
        }
        catch(Exception e){
            return null;
        }
        return users;
    }



    public void setUsers(List<User> users) {
        this.users = users;
    }
}
