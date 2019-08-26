package com.xiao.soccerproject.repository;

import com.xiao.soccerproject.model.Role;

public interface RoleDAO {
    Role getRoleByName(String name);
}
