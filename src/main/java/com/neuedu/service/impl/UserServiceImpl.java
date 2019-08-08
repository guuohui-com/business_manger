package com.neuedu.service.impl;

import com.neuedu.dao.UserInfoMapper;
import com.neuedu.pojo.UserInfo;
import com.neuedu.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserInfoService {

    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public int findByUserName(String username) {
        int rows=userInfoMapper.findByUserName(username);
        return rows;
    }

    @Override
    public UserInfo findByUserNameAndPassword(String username, String password) {
        //System.out.println("========serviceImpl======");
        UserInfo userInfo=userInfoMapper.findByUserNameAndPassword(username,password);
        //System.out.println("========serviceImpl======"+userInfo);
        return userInfo;
    }
    @Override
    public List<UserInfo> findByRole(int role){
        List<UserInfo> list =userInfoMapper.findByRole(role);
        return list;
    }
}
