package com.mrv.entity.abstracts;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mrv.entity.concrete.UserRole;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private String name;

    @OneToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private UserRole userRole;

    @Column(unique = true)
    private String email;

}
