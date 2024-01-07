package com.stage.eCommerce.services;

import com.stage.eCommerce.entities.Role;
import com.stage.eCommerce.entities.User;
import com.stage.eCommerce.repositories.RoleRepository;
import com.stage.eCommerce.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements IUserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    @Override
    public List<User> retrieveAllUsers() {
        List<User> users = (List<User>) userRepository.findAll();
        for (User user : users) {
            log.info(" User : " + user);
        }
        return users;
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public List<User> displayUsersWithRoles() {
        List<User> users = userRepository.findAll();
        for (User user : users) {
            System.out.println("User: " + user.getUsername());
            for (Role role : user.getRoles()) {
                System.out.println("Role: " + role.getName());
            }
        }
        return users;
    }

    @Override
    public List<Role> displayRoles() {
        return roleRepository.findAll();
    }
    /*
    public void updateUserRole(Long userId, Long roleId) {


        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            Optional<Role> roleOptional = roleRepository.findById(roleId);
            if (roleOptional.isPresent()) {
                Role role = roleOptional.get();
                user.getRoles().clear();
                user.getRoles().add(role);
                userRepository.save(user);
            } else {
                // Gérer l'absence du rôle avec l'ID spécifié
            }
        } else {
            // Gérer l'absence de l'utilisateur avec l'ID spécifié
        }
    }*/

   /* public boolean updateUserRole(Long userId, Long roleId) {
        Optional<User> userOptional = userRepository.findById(userId);
        Optional<Role> roleOptional = roleRepository.findById(roleId);

        if (userOptional.isPresent() && roleOptional.isPresent()) {
            User user = userOptional.get();
            Role role = roleOptional.get();
            user.getRoles().clear();
            user.getRoles().add(role);
            userRepository.save(user);
            return true;
        } else {
            return false;
        }
    }*/


    public boolean updateUserRole(Long userId, Long roleId) {
        Optional<User> userOptional = userRepository.findById(userId);
        Optional<Role> roleOptional = roleRepository.findById(roleId);

        if (userOptional.isPresent() && roleOptional.isPresent()) {
            User user = userOptional.get();
            Role role = roleOptional.get();
            user.getRoles().clear();
            user.getRoles().add(role);
            userRepository.save(user);
            return true;
        } else {
            return false;
        }
    }



}

