package com.neuedu.controller;

import com.neuedu.pojo.Category;
import com.neuedu.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
@RequestMapping("/user/category/")
public class CategoryController {
    @Autowired
    ICategoryService iCategoryService;
    @RequestMapping("find")
    public  String findAll(HttpSession session){
        List<Category> categoryList=iCategoryService.findAll();
        session.setAttribute("categoryList",categoryList);
        return "categoryList";
    }
    @RequestMapping(value = "update/{id}",method = RequestMethod.GET)
    public String update(@PathVariable("id") Integer categoryId,HttpServletRequest request){
        System.out.println("=======================" +categoryId);
        Category category =iCategoryService.findByCategoryId(categoryId);
        System.out.println(category);
        request.setAttribute("category",category);
        return "categoryupdate";
    }
    @RequestMapping(value = "update/{id}",method = RequestMethod.POST)
    public String update(Category category){
        System.out.println("================hello=="+category+"-===================================");
        int count =  iCategoryService.updateCategory(category);
        System.out.println(count+"===========================");
        if(count>0){
            return "redirect:/user/category/find";
        }
        return "categoryupdate";
    }

    @RequestMapping(value = "insert",method = RequestMethod.GET)
    public String inertpage(){
        return "insertCategory";
    }

    @RequestMapping(value = "insert",method = RequestMethod.POST)
    public String insert(Category category, HttpServletRequest request, HttpServletResponse response){
        try {
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println("======================"+category.getName());
        int rows=iCategoryService.addCategory(category);
        System.out.println("==============rows=========="+rows);
        if(rows>0){
            return "redirect:/user/category/find";
        }else{
            return "insertCategory";
        }
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable("id") int categoryId){
        int rows = iCategoryService.deleteByPrimaryKey(categoryId);
        if(rows>0){
            return "redirect:/user/category/find";
        }else{
            return "categoryupdate";
        }
    }
}
