package com.kloudspot.service;

import java.util.List;

import com.kloudspot.exception.UserNotFoundException;
import com.kloudspot.models.User;
import com.kloudspot.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired private UserRepository userRepository;

	@Override
	public User getById(int id) throws UserNotFoundException {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User with id " + id + " not found."));
        return user;
	}

	@Override
	public List<User> getAll() {
        return userRepository.findAll();
	}

	@Override
	public List<User> getByFirstName(String name) throws UserNotFoundException {
        List<User> users = userRepository.findByFirstName(name);

        if (users.isEmpty()) {
            throw new UserNotFoundException("user with first name " + name + " not found");
        }

        return users;
	}

	@Override
	public List<User> getByLastName(String name) throws UserNotFoundException {
        List<User> users = userRepository.findByLastName(name);

        if (users.isEmpty()) {
            throw new UserNotFoundException("user with last name " + name + " not found");
        }

        return users;
	}

	@Override
	public List<User> getByCity(String city) throws UserNotFoundException {
        List<User> users = userRepository.findByAddressCity(city);

        if (users.isEmpty()) {
            throw new UserNotFoundException("user with city " + city + " not found");
        }

        return users;

	}

	@Override
	public List<User> getByState(String state) throws UserNotFoundException {
        List<User> users = userRepository.findByAddressState(state);

        if (users.isEmpty()) {
            throw new UserNotFoundException("user with state " + state + " not found");
        }

        return users;
	}

	@Override
	public List<User> getByPincode(String pincode) throws UserNotFoundException {
        List<User> users = userRepository.findByAddressPincode(pincode);

        if (users.isEmpty()) {
            throw new UserNotFoundException("user with pincode " + pincode + " not found");
        }

        return users;
	}

	@Override
	public User addUser(User user) {
	    if (user.getId() < 0) {
	        user.setId((int)userRepository.count()+1);
        }

        User addedUser = userRepository.insert(user);
	    addedUser.setPassword(null);
        return addedUser;
	}

	@Override
	public User updateUser(User user) throws UserNotFoundException {
        userRepository.findById(user.getId()).orElseThrow(() -> new UserNotFoundException("User with id " + user.getId() + " not found."));

        User updateUser = userRepository.save(user);
        return updateUser;
	}

	@Override
	public void deleteUser(int id) throws UserNotFoundException {
        userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User with id " + id + " not found."));
        userRepository.deleteById(id);
	}
}
