package com.kloudspot.service;

import java.util.List;

import com.kloudspot.exception.UserNotFoundException;
import com.kloudspot.models.User;

/**
 * UserService
 */
public interface UserService {
    // C
    User addUser(User user);

    // R
    User getById(int id) throws UserNotFoundException;
    List<User> getAll();
    List<User> getByFirstName(String name) throws UserNotFoundException;
    List<User> getByLastName(String name) throws UserNotFoundException;
    List<User> getByCity(String city) throws UserNotFoundException;
    List<User> getByState(String state) throws UserNotFoundException;
    List<User> getByPincode(String pincode) throws UserNotFoundException;

    // U
    User updateUser(User user) throws UserNotFoundException;

    // D
    void deleteUser(int id) throws UserNotFoundException;
}
