package com.novare.eika.dao.user;

import com.novare.eika.models.User;

import java.util.List;

public interface IUserDao {
    List<User> getAll();
    User get(long id);
    User findByEmail(String email);
    User register(User user);
}
