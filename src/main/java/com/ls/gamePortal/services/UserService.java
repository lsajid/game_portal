package com.ls.gamePortal.services;

import com.ls.gamePortal.models.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserService {
    List<User> users = new ArrayList<>(
            Arrays.asList(
                    new User(1, "Test1", "test1@test.com", "abc1"),
                    new User(2, "Test2", "test2@test.com", "abc2")
            )
    );


    public List<User> retrieveAll(){
        return users;
    }

    public User retrieveOne(int id){
        return users.get(id-1);
    }

    public User createOne(User user){
        users.add(user);
        return user;
    }

    public void updateOne(int id, User user){
        for(int i=0;i<users.size();i++) {
            User currentUser = users.get(i);
            if(currentUser.getId() == id) {
                users.set(i, user);
                return;
            }
        }
        System.out.println("User not found");
    }

    public void removeOne(int id) {
        for(User currentUser: users) {
            if(currentUser.getId() == id) {
              users.remove(currentUser);
              return;
            }
        }
        System.out.println("User not found");
    }

}
