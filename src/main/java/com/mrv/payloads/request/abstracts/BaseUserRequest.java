package com.mrv.payloads.request.abstracts;

import com.mrv.utilis.Messages;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@SuperBuilder
@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseUserRequest {
    @NotNull(message= Messages.BASE_USER_ENTER_USERNAME)
    @Size(min=4,max = 16,message =Messages.BASE_USER_SIZE_USERNAME)
    @Pattern(regexp = "\\A(?!\\s*\\Z).+", message = Messages.BASE_USER_PATTERN_USERNAME)
    private String username;
    @NotNull(message= "please enter your name")
    @Size(min=4,max = 16,message = "Your name should be at least 4 characters")
    @Pattern(regexp = "\\A(?!\\s*\\Z).+", message = "Your name must consist of the characters .")
    private String name;
    @NotNull(message= Messages.BASE_USER_ENTER_PASSWORD)
    @Size(min=8,message = Messages.BASE_USER_SIZE_MIN_PASSWORD)
    @Size(max=60,message = Messages.BASE_USER_SIZE_MAX_PASSWORD)
    @Pattern(regexp = "\\A(?!\\s*\\Z).+", message = Messages.BASE_USER_PATTERN_PASSWORD)
    private String password;
    @NotNull(message = Messages.BASE_USER_ENTER_EMAIL)
    @Email(message = Messages.BASE_USER_VALIDATION_EMAIL)
    @Size(min=5, max=50 , message = Messages.BASE_USER_SIZE_EMAIL)
    private String email;
}
