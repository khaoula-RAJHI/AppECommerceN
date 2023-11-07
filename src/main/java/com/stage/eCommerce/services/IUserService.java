package com.stage.eCommerce.services;

import com.stage.eCommerce.entities.User;

import java.util.List;

public interface IUserService {
    List<User> retrieveAllUsers();

    void deleteUser(Long id);
    List<User> displayUsersWithRoles();

    //void updateUserRole(Long userId, Long roleId);
    boolean updateUserRole(Long userId, Long roleId);

}
