package com.kloudspot.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class RegistrationDTO {
    @NotNull
    @Email
    private String emailId;

    @NotNull
    private String firstname;

    @NotNull
    private String lastname;

    @NotNull
    @Size(min = 8)
    private String password;

    private Address address;
}
