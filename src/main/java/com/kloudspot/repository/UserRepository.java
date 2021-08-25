package com.kloudspot.repository;

import java.util.List;

import com.kloudspot.models.User;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, Integer> {
    List<User> findByFirstName(String name);
    List<User> findByLastName(String name);
    List<User> findByAddressCity(String city);
    List<User> findByAddressState(String state);
    List<User> findByAddressPincode(String pincode);
}
