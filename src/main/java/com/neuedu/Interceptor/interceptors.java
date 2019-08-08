package com.neuedu.Interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class interceptors implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        //返回值为false表示不通过，为true表示通过
        //请求到controller之前执行
        HttpSession session=request.getSession();
        Cookie[] cookies = request.getCookies();
        String username=null;
        String password=null;
        if(cookies!=null){
            for(Cookie cookie:cookies){
                if(cookie.getName().equals("username")){
                    username=cookie.getValue();
                }
                if(cookie.getName().equals("password")){
                    password=cookie.getValue();
                }
            }
        }else{
            try {
                System.out.println("=======================/login");
                response.sendRedirect("/login");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("========preHandle========"+username+"=============="+password);
        if(!(username ==null)){
            session.setAttribute("username",username);
            session.setAttribute("password",password);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        //controller给diaspatcherServlet响应时调用
        System.out.println("=========postHandler==========");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        //给客户端响应之后
        System.out.println("=======afterCompletion========");
    }
}
