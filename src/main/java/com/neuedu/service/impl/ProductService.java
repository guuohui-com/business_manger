package com.neuedu.service.impl;

import com.neuedu.dao.ProductMapper;
import com.neuedu.pojo.Product;
import com.neuedu.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService{

    @Autowired
    ProductMapper productMapper;

    @Override
    public int addProduct(Product product) {
        return productMapper.insert(product);
    }

    @Override
    public int deleteProduct(int productId) {
        return productMapper.deleteByPrimaryKey(productId);
    }

    @Override
    public int updateProduct(Product product) {
       int rows= productMapper.updateByPrimaryKey(product);
        System.out.println("=======================service"+product);
        System.out.println("=================service"+rows);
        return rows;
    }

    @Override
    public List<Product> searchProductAll() {
        List<Product> productList= productMapper.selectAll();
        for (Product product:productList){
            System.out.println(product.getName());
        }
        return productList;
    }

    @Override
    public Product selectByPrimaryKey(Integer id) {
        Product product=productMapper.selectByPrimaryKey(id);
        return product;
    }

}
