package com.neuedu.service;

import com.neuedu.pojo.Category;

import java.util.List;

public interface ICategoryService
{
    //添加类别
    public int addCategory(Category category);
    //删除类别
    public int deleteCategory(int categoryId);
    //修改类别
    public int updateCategory(Category category);
    //查询类别
    public List<Category> findAll();
    //根据类别Id查询类别信息
    public Category findByCategoryId(int category);
    //根据id删除
    public int deleteByPrimaryKey(Integer id);

}
