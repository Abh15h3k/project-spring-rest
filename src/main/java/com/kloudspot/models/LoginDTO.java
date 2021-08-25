package com.kloudspot.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {
    @NotNull
    @Email
    private String emailId;

    @NotNull
    private String password;
}
