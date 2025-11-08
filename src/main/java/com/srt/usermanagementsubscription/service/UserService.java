package com.srt.usermanagementsubscription.service;

import com.srt.usermanagementsubscription.model.User;

import java.util.List;

public interface UserService {
    public User addUser(User user);
    public User updateUser(User user);
    public void deleteUser(long id);
    public List<User> findUsers();
    public User findUserById(int id);
}
