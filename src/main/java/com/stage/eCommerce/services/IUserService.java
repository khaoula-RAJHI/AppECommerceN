package com.stage.eCommerce.services;

<<<<<<< Updated upstream
=======
import com.stage.eCommerce.entities.Role;
>>>>>>> Stashed changes
import com.stage.eCommerce.entities.User;

import java.util.List;

public interface IUserService {
    List<User> retrieveAllUsers();

    void deleteUser(Long id);
    List<User> displayUsersWithRoles();
<<<<<<< Updated upstream
=======
    List<Role> displayRoles();
>>>>>>> Stashed changes

    //void updateUserRole(Long userId, Long roleId);
    boolean updateUserRole(Long userId, Long roleId);

}
