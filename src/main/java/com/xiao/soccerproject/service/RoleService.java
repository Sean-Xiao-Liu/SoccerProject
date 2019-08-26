package com.xiao.soccerproject.service;

import com.xiao.soccerproject.model.Role;
import com.xiao.soccerproject.repository.RoleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleDAO roleDAO;

    public Role getRoleByName(String name) {
        return roleDAO.getRoleByName(name);
    }

}
