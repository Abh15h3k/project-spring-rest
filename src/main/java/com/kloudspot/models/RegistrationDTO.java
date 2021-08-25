package com.kloudspot.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class RegistrationDTO {
    private  String emailId;

    private String firstName;

    private String lastName;

    private String password;

    private Address address;
}
