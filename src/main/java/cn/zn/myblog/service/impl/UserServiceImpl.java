package cn.zn.myblog.service.impl;

import cn.zn.myblog.dao.UserDao;
import cn.zn.myblog.entity.User;
import cn.zn.myblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User checkUser(User user) {
        User res =userDao.findByUsernameAndPassword(user);
        return res;
    }
}
