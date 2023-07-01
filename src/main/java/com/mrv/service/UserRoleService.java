package com.mrv.service;

import com.mrv.entity.concrete.UserRole;
import com.mrv.entity.enums.RoleType;
import com.mrv.exceptions.ConflictException;
import com.mrv.repository.UserRoleRepository;
import com.mrv.utilis.Messages;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserRoleService {
    private final UserRoleRepository userRoleRepository;

    public UserRole getUserRole(RoleType roleType){
        Optional<UserRole> userRole=userRoleRepository.findByEnumRoleEquals(roleType);

        return userRoleRepository.findByEnumRoleEquals(roleType).orElseThrow(
                ()-> new ConflictException(Messages.ROLE_NOT_FOUND));
    }

    public List<UserRole> getAllUserRole(){
        return userRoleRepository.findAll();
    }

    public UserRole save(RoleType roleType){
        if(userRoleRepository.existsByEnumRoleEquals(roleType)){
            throw new ConflictException(Messages.ROLE_ALREADY_EXIST);
        }
        UserRole userRole= UserRole.builder()
                .roleType(roleType)
                .build();
        return userRoleRepository.save(userRole);
    }





}
