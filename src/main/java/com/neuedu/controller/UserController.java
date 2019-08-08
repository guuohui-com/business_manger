package com.neuedu.controller;

import com.neuedu.pojo.UserInfo;
import com.neuedu.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    IUserInfoService iUserService;
    @RequestMapping("/login")
    public String prelogin(){
        return "login";
    }

    @RequestMapping("/loginsuccess")
    public String Login(@RequestParam("username") String username, @RequestParam("password")String password,
                        HttpServletRequest request, HttpServletResponse response, HttpSession session){
        session=request.getSession();
        int tem=iUserService.findByUserName(username);
        UserInfo userInfo=null;
        String mangerUaerNmae;
        String mangerPassword;
        if(tem==0){
            System.out.println("========用户不存在=======");
            return "loginError";
        }else{
             userInfo= iUserService.findByUserNameAndPassword(username,password);
             if(userInfo==null){
                 System.out.println("=======密码错误==========");
                 return "loginError";
             }else{
                 System.out.println("===========登录成功=============");
                 if(userInfo.getRole()==0){
                     //mangerUaerNmae= (String) session.getAttribute("username");
                     //mangerPassword= (String) session.getAttribute("password");
                     //if((mangerPassword==null)&&(mangerUaerNmae==null)){
                     System.out.println("===================================Cookie");
                         Cookie username_cookie=new Cookie("username",username);
                         Cookie password_cookie=new Cookie("password",password);
                         username_cookie.setMaxAge(7*24*60*60);
                         password_cookie.setMaxAge(7*24*60*60);
                         return "mangerLogin";
                         //return "redirect:commonuser";
                     //}else{
                     //   return "mangerLogin";
                    // }
                     //将管理员用户的uaername，password放入cookie
                 }else{
                     return "userLogin";
                 }
             }
        }
    }

    @RequestMapping(value = "/commonuser")
    public  String searchCommonUser(HttpSession session){
        System.out.println("==============commonuer");
        List<UserInfo> userInfoList=iUserService.findByRole(1);
        System.out.println("================userInfoList=========="+userInfoList);
        session.setAttribute("userInfoList",userInfoList);
        for(UserInfo userInfo: userInfoList){
            System.out.println("=====================ID====="+userInfo.getId());
        }
        return "commonUser";
    }

    /*@RequestMapping("/commonuserSecond")
    public String searchCommonUser(){
        return "commonUser";
    }*/

}
