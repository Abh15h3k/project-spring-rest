package com.kloudspot.models;

import java.util.List;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Product {
    @Id
    private Integer id;

    private String name;

    private int userId;

    private List<String> category;

    private double price;

    private boolean hasWarranty;

    private int ageInMonths;

    private String image;
}
