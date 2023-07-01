package com.mrv.payloads.mappers;

import com.mrv.entity.concrete.Admin;
import com.mrv.payloads.request.AdminRequest;
import com.mrv.payloads.response.AdminResponse;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class AdminMappers {

    public Admin mapAdminRequestToAdmin(AdminRequest adminRequest){
        return Admin.builder()
                .username(adminRequest.getUsername())
                .email(adminRequest.getEmail())
                .name(adminRequest.getName())
                .password(adminRequest.getPassword())
                .build();
    }

    public AdminResponse mapAdminToAdminResponse(Admin admin){
        return AdminResponse.builder()
                .userId(admin.getId())
                .username(admin.getUsername())
                .name(admin.getName())
                .email(admin.getEmail())
                .build();
    }


}
