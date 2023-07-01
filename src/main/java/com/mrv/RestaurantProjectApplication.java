package com.mrv;

import com.mrv.entity.enums.RoleType;
import com.mrv.payloads.request.AdminRequest;
import com.mrv.service.AdminService;
import com.mrv.service.UserRoleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;



@SpringBootApplication
public class RestaurantProjectApplication implements CommandLineRunner {
    private final UserRoleService userRoleService;
    private final AdminService adminService;
    private final PasswordEncoder passwordEncoder;

    public RestaurantProjectApplication( UserRoleService userRoleService, AdminService adminService, PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        this.userRoleService = userRoleService;
        this.adminService = adminService;
    }

    public static void main(String[] args) {
        SpringApplication.run(RestaurantProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if(userRoleService.getAllUserRole().isEmpty()){
            userRoleService.save(RoleType.ADMIN);
        }
        if (adminService.countAllAdmins()==0) {
            AdminRequest adminRequest = new AdminRequest();
            adminRequest.setUsername("Admin1");
            adminRequest.setEmail("minerulupeni@gmail.com");
            adminRequest.setName("Gicutu");
            adminRequest.setPassword("Parola99");
            adminService.save(adminRequest);
        }
    }
}
