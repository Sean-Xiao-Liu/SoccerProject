package com.xiao.soccerproject.model;




import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "allowed_resource")
    private String allowedResource;

    @Column(name = "allowed_read")
    private String allowedRead;

    @Column(name= "allowed_create")
    private String allowedCreate;

    @Column(name = "allowed_update")
    private String allowedUpdate;

    @Column(name = "allowed_delete")
    private String allowedDelete;

    @ManyToMany(mappedBy = "roles",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private Set<User> users;

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

    public String getAllowedRead() {
        return allowedRead;
    }

    public void setAllowedRead(String allowedRead) {
        this.allowedRead = allowedRead;
    }

    public String getAllowedCreate() {
        return allowedCreate;
    }

    public void setAllowedCreate(String allowedCreate) {
        this.allowedCreate = allowedCreate;
    }

    public String getAllowedUpdate() {
        return allowedUpdate;
    }

    public void setAllowedUpdate(String allowedUpdate) {
        this.allowedUpdate = allowedUpdate;
    }

    public String getAllowedDelete() {
        return allowedDelete;
    }

    public void setAllowedDelete(String allowedDelete) {
        this.allowedDelete = allowedDelete;
    }

//    public Set<User> getUsers() {
//        return users;
//    }

    public Set<User> getUsers() {
        try {
            int size = users.size();
        }
        catch(Exception e){
            return null;
        }
        return users;
    }



    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
