package com.neuedu.service;

import com.neuedu.pojo.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUserInfoService {
    public int findByUserName(String username);
    public UserInfo findByUserNameAndPassword(@Param("usernaem") String username, @Param("password") String password);
    public List<UserInfo> findByRole(int role);
}
