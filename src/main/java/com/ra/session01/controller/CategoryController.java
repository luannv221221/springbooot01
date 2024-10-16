package com.ra.session01.controller;

import com.ra.session01.model.entity.Category;
import com.ra.session01.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping()
    public String index(Model model){
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categoryList",categoryList);
        return "category/index";
    }
}
