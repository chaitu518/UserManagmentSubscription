package com.srt.usermanagementsubscription.repository;

import com.srt.usermanagementsubscription.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class InMemoryRegistry {
    Map<Long, User> users;
    private long id=1;
    public InMemoryRegistry() {
        users = new HashMap<Long, User>();
    }
    public User add(User user) {
        user.setId(++id);
        users.put(user.getId(), user);
        return user;
    }
    public User get(long id) {
        return users.get(id);
    }
    public List<User> getAll() {
        return new ArrayList<User>(users.values());
    }
    public boolean remove(long id) {
        if(users.containsKey(id)) {
            users.remove(id);
            return true;
        }
        return false;
    }
    public User findUser(long id) {
       if(users.containsKey(id)) {
           return users.get(id);
       }
       return null;
    }
    public User UpdateUser(User user) {
        if(users.containsKey(id)) {
            User user1 = users.get(user.getId());
            if(user.getName()!=null){
                user1.setName(user.getName());
            }
            if(user.getAddress()!=null){
                user1.setAddress(user.getAddress());
            }
            if(user.getPlanName()!=null){
                user1.setPlanName(user.getPlanName());
            }
            if(user.getSubscription()!=null){
                user1.setSubscription(user.getSubscription());
            }
            users.put(user.getId(), user1);
            return users.get(user.getId());
        }
        return null;
    }
}
