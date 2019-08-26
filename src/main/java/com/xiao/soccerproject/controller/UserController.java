package com.xiao.soccerproject.controller;

import com.xiao.soccerproject.model.Game;
import com.xiao.soccerproject.model.Team;
import com.xiao.soccerproject.model.User;
import com.xiao.soccerproject.service.TeamService;
import com.xiao.soccerproject.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, params = {"email"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public User getUserByEmail(@RequestParam(value = "email") String email){
        User user = userService.getUserByEmail(email);
        return user;
    }

}
