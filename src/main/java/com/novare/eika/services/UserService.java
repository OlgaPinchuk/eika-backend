package com.novare.eika.services;

import com.novare.eika.dao.user.IUserDao;
import com.novare.eika.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    IUserDao iUserDao;

    public List<User> getAll(){
        return iUserDao.getAll();
    }

    public User get(long id){
        return iUserDao.get(id);
    }

    public User findByEmail(String email) {
        return iUserDao.findByEmail(email);
    }

    public User create(User user) {
        return iUserDao.register(user);
    }
}