package com.neuedu.service.impl;

import com.neuedu.dao.CategoryMapper;
import com.neuedu.pojo.Category;
import com.neuedu.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryImpl implements ICategoryService{


    @Autowired
    CategoryMapper categoryMapper;
    @Override
    public int addCategory(Category category) {
        return categoryMapper.insert(category);
    }

    @Override
    public int deleteCategory(int categoryId) {
        return 0;
    }

    @Override
    public int updateCategory(Category category) {
        System.out.println("==============service+============"+category);
        int row= categoryMapper.updateByPrimaryKey(category);
        System.out.println("===================="+row);
        return row;
    }

    @Override
    public List<Category> findAll() {
        return categoryMapper.selectAll();
    }

    @Override
    public Category findByCategoryId(int categoryId) {
        return categoryMapper.selectByPrimaryKey(categoryId);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {

        return categoryMapper.deleteByPrimaryKey(id);
    }

}
