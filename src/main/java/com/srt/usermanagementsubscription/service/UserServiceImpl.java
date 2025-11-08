package com.srt.usermanagementsubscription.service;

import com.srt.usermanagementsubscription.Exceptions.CustomExceptions.UserNotFoundException;
import com.srt.usermanagementsubscription.model.User;
import com.srt.usermanagementsubscription.repository.InMemoryRegistry;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class UserServiceImpl implements UserService {
    private InMemoryRegistry inMemoryRegistry;
    public UserServiceImpl(InMemoryRegistry inMemoryRegistry) {
        this.inMemoryRegistry = inMemoryRegistry;
    }
    @Override
    public User addUser(User user) {
        User newUser = new User();
        newUser.setName(user.getName());
        newUser.setAddress(user.getAddress());
        newUser.setPlanName(user.getPlanName());
        newUser.setSubscription(user.getSubscription());
        return inMemoryRegistry.add(newUser);
    }

    @Override
    public User updateUser(User user) {
        User finduser = inMemoryRegistry.findUser(user.getId());
        if (finduser == null) {
            throw new UserNotFoundException("User id is not foud");
        }
        return inMemoryRegistry.UpdateUser(user);
    }

    @Override
    public void deleteUser(long id) {
        boolean isDeleted = inMemoryRegistry.remove(id);
        if (!isDeleted) {
            throw new UserNotFoundException("User id is not foud");
        }
    }

    @Override
    public List<User> findUsers() {
        return inMemoryRegistry.getAll();
    }

    @Override
    public User findUserById(long id) {
        User user = inMemoryRegistry.findUser(id);
        if (user == null) {
            throw new UserNotFoundException("User id is not foud");
        }
        return user;
    }
}
