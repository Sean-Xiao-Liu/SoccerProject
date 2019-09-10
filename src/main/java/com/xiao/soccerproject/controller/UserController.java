package com.xiao.soccerproject.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.xiao.soccerproject.model.Game;
import com.xiao.soccerproject.model.Team;
import com.xiao.soccerproject.model.User;
import com.xiao.soccerproject.service.TeamService;
import com.xiao.soccerproject.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @RequestMapping(value="/getUser",method = RequestMethod.GET, params = {"email"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @JsonView(User.DefUserInfo.class)
    public User getUserByEmail(@RequestParam(value = "email") String email){
        User user = userService.getUserByEmail(email);
        return user;
    }

    @RequestMapping(value = "/getUserByCredentials", method = RequestMethod.GET, params = {"email", "password"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @JsonView(User.AdvUserInfo.class)
    public User getUserByCredentials(@RequestParam(value = "email") String email, @RequestParam(value = "password") String password){
        User user = userService.getUserByCredentials(email,password);
        return user;
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public String saveUser(@RequestBody User user){
        String msg = "the user has been created";
        boolean isSuccess = userService.save(user);
        if(!isSuccess) msg = "the user has not been created";
        return msg;
    }


    @RequestMapping(value = "/getUsers",method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    @JsonView(User.DefUserInfo.class)
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.PUT, produces = {MediaType.APPLICATION_JSON_VALUE})
    public String updateUser(@RequestBody User user){
        String msg = "the user info has not been updated";
        int isSuccess = userService.updateUser(user);
        if(isSuccess > 0) msg = "the team info has been updated";
        return msg;
    }

    @RequestMapping(value = "/deleteUserById/{userId}", method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE})
    public String deleteUserById(@PathVariable long userId){
        String msg = "the user has not been deleted";
        int isSuccess = userService.deleteUserById(userId);
        if(isSuccess > 0) msg = "the user has been deleted";
        return msg;
    }

    @RequestMapping(value = "/deleteUserByEmail", method = RequestMethod.DELETE, params = {"email"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public String deleteUserByEmail(@RequestParam(value = "email") String email){
        String msg = "the user has not been deleted";
        int isSuccess = userService.deleteUserByEmail(email);
        if(isSuccess > 0) msg = "the user has been deleted";
        return msg;
    }
}
