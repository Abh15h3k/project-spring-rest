package com.kloudspot.models;

import java.util.List;

import com.mongodb.lang.NonNull;
import org.hibernate.validator.internal.constraintvalidators.hv.EmailValidator;
import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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
    private String emailId;
    private String password;

    private Address address;
}