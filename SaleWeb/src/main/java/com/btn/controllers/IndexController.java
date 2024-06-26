/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btn.controllers;

import com.btn.services.CategoryService;
import com.btn.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 *
 * @author admin
 */
@Controller
@ControllerAdvice // dung chung cho cac controller khac
public class IndexController {
    @Autowired
    private CategoryService cateService;
    @Autowired
    private ProductService prodService;
    
    @ModelAttribute
    public void commonAttr(Model model) {
        // phan header chung va gan @modelattribute
        model.addAttribute("categories", this.cateService.getCates());
    }
    
    @RequestMapping("/")
    public String index(Model model,
            @RequestParam Map<String, String> params) {
        
        model.addAttribute("products", this.prodService.getProducts(params));
        return "index";
    }
}