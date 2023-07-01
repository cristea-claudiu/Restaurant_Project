package com.mrv.service;

import com.mrv.entity.concrete.Admin;
import com.mrv.entity.enums.RoleType;
import com.mrv.exceptions.ConflictException;
import com.mrv.payloads.mappers.AdminMappers;
import com.mrv.payloads.request.AdminRequest;

import com.mrv.payloads.response.AdminResponse;
import com.mrv.payloads.response.ResponseMessage;
import com.mrv.repository.AdminRepository;
import com.mrv.utilis.Messages;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AdminService {
    private final AdminRepository adminRepository;
    private final UserRoleService  userRoleService;
    private final PasswordEncoder passwordEncoder;
    private final AdminMappers adminMappers;

    public ResponseMessage<AdminResponse> save(AdminRequest adminRequest){
        if (adminRepository.existsByUsername(adminRequest.getUsername())){
            throw new ConflictException(Messages.USERNAME_ALREADY_REGISTERED);
        }

        Admin admin=adminMappers.mapAdminRequestToAdmin(adminRequest);
        admin.setPassword(passwordEncoder.encode(adminRequest.getPassword()));
        admin.setUserRole(userRoleService.getUserRole(RoleType.ADMIN));
        Admin savedAdmin=adminRepository.save(admin);
        return ResponseMessage.<AdminResponse>builder()
               .message("Admin saved")
               .httpStatus(HttpStatus.CREATED)
               .object(adminMappers.mapAdminToAdminResponse(savedAdmin))
               .build();
    }

    public long countAllAdmins(){
        return adminRepository.count();
    }


}
