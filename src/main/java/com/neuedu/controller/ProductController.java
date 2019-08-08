package com.neuedu.controller;

import com.neuedu.pojo.Product;
import com.neuedu.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Controller
public class ProductController {
    @Autowired
    IProductService iProductService;
    @RequestMapping("selectall")
    public String selectAll(HttpSession session){
        List<Product> productList=iProductService.searchProductAll();
        session.setAttribute("productList",productList);
        return "hello";
    }

    @RequestMapping("deleteproduct/{id}")
    public String deleteProduct(@PathVariable("id") int productId){
        int rows=iProductService.deleteProduct(productId);
        System.out.println("========================"+rows);
        System.out.println("========================"+productId);
        if(rows>0){
            System.out.println("==================删除成功========");
           return "redirect:/selectall";
        }else {
            System.out.println("===================删除失败====");
            return "forward:insertproductB";
        }
    }

    @RequestMapping("insertproductA")
    public String insertProduct(@RequestParam("name") String name, @RequestParam("categoryId") int categoryId,
                                @RequestParam("price") BigDecimal price, @RequestParam("stock") int stock,
                                @RequestParam("status") int status, @RequestParam("mainImage") MultipartFile mainImage,
                                @RequestParam("subImage") MultipartFile subImage){
        String mainfileName=null;
        String subfileName=null;
        if(mainImage!=null){
            String uuid= UUID.randomUUID().toString();
            mainfileName=mainImage.getOriginalFilename();
            String extendName=mainfileName.substring(mainfileName.lastIndexOf("."));
            mainfileName=uuid+extendName;

            File file=new File("E:\\实训视频\\springMVC\\upload");
            if(!file.exists()){
                file.mkdir();
            }
            File newfile=new File(file,mainfileName);
            try {
                mainImage.transferTo(newfile);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        if(subImage!=null){
            String uuid= UUID.randomUUID().toString();
            subfileName=subImage.getOriginalFilename();
            String extendName=subfileName.substring(subfileName.lastIndexOf("."));
            subfileName=uuid+extendName;

            File file=new File("E:\\实训视频\\springMVC\\upload");
            if(!file.exists()){
                file.mkdir();
            }
            File newfile=new File(file,subfileName);
            try {
                subImage.transferTo(newfile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Product product=new Product();
        product.setCategoryId(categoryId);
        product.setName(name);
        product.setStock(stock);
        product.setPrice(price);
        product.setStatus(status);
        product.setMainImage(mainfileName);
        product.setSubImages(subfileName);
        System.out.println(product.getMainImage());

        int rows =iProductService.addProduct(product);
        if(rows>0){
            return "forward:selectall";
        }else{
            System.out.println("=======插入失败=====");
            return "loginError";
        }
    }

    @RequestMapping("insertproductB")
    public String insert(){
        return "insertProduct";
    }

    @RequestMapping("updateproductA")
    public String updateProduct(Product product){
        System.out.println("==============updateproductA==============="+product);
        int rows=iProductService.updateProduct(product);
        System.out.println("====================================="+rows);
        if(rows>0){
            return "forward:selectall";
        }
        return "loginError";
    }

    @RequestMapping("updateproducrB/{id}")
    public String update(@PathVariable("id") int id, HttpServletRequest request){
        Product product =iProductService.selectByPrimaryKey(id);
        request.setAttribute("product",product);
        return "updateProduct";
    }

}
