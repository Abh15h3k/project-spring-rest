package com.kloudspot.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
@Validated
public class User {
    @Id
    private Integer id;

    @NotNull
    private String firstName;
    @NotNull
    private String lastName;

    @NotNull
    @Email
    @Indexed(unique = true)
    private String emailId;
    private String password;

    private Address address;

    private List<String> roles;
}