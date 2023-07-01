package com.mrv.repository;

import com.mrv.entity.concrete.UserRole;
import com.mrv.entity.enums.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRoleRepository extends JpaRepository<UserRole,Integer> {
    @Query("SELECT r FROM UserRole r WHERE r.roleType = ?1")
    Optional<UserRole> findByEnumRoleEquals(RoleType roleType);
    @Query("SELECT (count (r)>0) FROM UserRole r WHERE r.roleType=?1")
    boolean existsByEnumRoleEquals(RoleType roleType);

}
