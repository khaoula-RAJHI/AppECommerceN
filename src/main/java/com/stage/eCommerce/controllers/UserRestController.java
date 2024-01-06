package com.stage.eCommerce.controllers;

import com.stage.eCommerce.entities.Produit;
import com.stage.eCommerce.entities.Role;
import com.stage.eCommerce.entities.User;
import com.stage.eCommerce.repositories.RoleRepository;
import com.stage.eCommerce.services.IProduitService;
import com.stage.eCommerce.services.IUserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@Api(tags = "Gestion des users")
@RequestMapping("/user")
public class UserRestController {
    @Autowired
    IUserService userService;
    @Autowired
    RoleRepository roleRepository;

    @GetMapping("/retrieve-all-users")
    @ResponseBody
    public List<User> getUsers() {
        List<User> list = userService.retrieveAllUsers();
        return list;
    }

    @DeleteMapping("/remove-user/{user-id}")
    @ResponseBody
    public void removeUser(@PathVariable("user-id") Long userId) {
        userService.deleteUser(userId);
    }

<<<<<<< Updated upstream
    @GetMapping("/displayRoles")
=======
    @GetMapping("/displayUsersRoles")
>>>>>>> Stashed changes
    @ResponseBody
    public  List<User> displayUsersWithRoles() {
        List<User> list = userService.displayUsersWithRoles();
        return list;
    }

<<<<<<< Updated upstream
=======
    @GetMapping("/displayRoles")
    @ResponseBody
    public  List<Role> displayRoles() {
        List<Role> list = userService.displayRoles();
        return list;
    }

>>>>>>> Stashed changes
    @PutMapping("/{userId}/roles/{roleId}")
    public ResponseEntity<String> updateUserRole(@PathVariable Long userId, @PathVariable Long roleId) {
        if (userService.updateUserRole(userId, roleId)) {
            return ResponseEntity.ok("Rôle de l'utilisateur mis à jour avec succès.");
        } else {
            return ResponseEntity.notFound().build(); // ou une réponse appropriée en cas d'échec de la mise à jour
        }
    }

}
