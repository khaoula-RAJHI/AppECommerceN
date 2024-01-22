package com.stage.eCommerce;

        import com.stage.eCommerce.entities.ERole;
        import com.stage.eCommerce.entities.Role;
        import com.stage.eCommerce.repositories.RoleRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.CommandLineRunner;
        import org.springframework.context.annotation.Bean;
        import org.springframework.context.annotation.Configuration;

@Configuration
public class InitialDataLoader {

    @Autowired
    private RoleRepository roleRepository;

    @Bean
    public CommandLineRunner initializeRoles() {
        return args -> {
            createRoleIfNotExists(ERole.ADMIN);
            createRoleIfNotExists(ERole.CLIENT);
        };
    }

    private void createRoleIfNotExists(ERole roleName) {
        if (!roleRepository.existsByName(roleName)) {
            Role role = new Role();
            role.setName(roleName);
            roleRepository.save(role);
        }
    }
}
