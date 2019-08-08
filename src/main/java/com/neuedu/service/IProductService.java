package com.neuedu.service;

import com.neuedu.pojo.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProductService {
    //增加
    public int addProduct(Product product);
    //删除
    public int deleteProduct(int productId);
    //更改
    public int updateProduct(Product product);
    //查询所有
    public List<Product> searchProductAll();
    //查找单个
    Product selectByPrimaryKey(Integer id);
}
