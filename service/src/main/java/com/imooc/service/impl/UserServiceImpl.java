package com.imooc.service.impl;

import com.imooc.enums.Sex;
import com.imooc.mapper.UsersMapper;
import com.imooc.pojo.Users;
import com.imooc.pojo.bo.UserBO;
import com.imooc.service.UserService;
import com.imooc.utils.DateUtils;
import com.imooc.utils.MD5Utils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.Date;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UsersMapper usersMapper;

    private static final String USER_FACE = "https://dss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2216831448,633613309&fm=26&gp=0.jpg";

    public UserServiceImpl(UsersMapper usersMapper) {
        this.usersMapper = usersMapper;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public boolean usernameExists(String username) {
        Example example = new Example(Users.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username", username);
        Users result = usersMapper.selectOneByExample(example);
        return result != null;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Users createUser(UserBO userBO) {
        Users user = new Users();
        user.setUsername(userBO.getUsername());
        try {
            user.setPassword(MD5Utils.encode(userBO.getPassword()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        user.setNickname(userBO.getUsername());
        user.setFace(USER_FACE);
        try {
            user.setBirthday(DateUtils.parse("2000-01-01"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        user.setSex(Sex.secret.type);
        user.setCreatedTime(new Date());
        user.setUpdatedTime(new Date());
        user.setId(UUID.randomUUID().toString());
        usersMapper.insert(user);
        return user;
    }
}
