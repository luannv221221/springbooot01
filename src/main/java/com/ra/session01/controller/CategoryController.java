package com.ra.session01.controller;

import com.ra.session01.model.entity.Category;
import com.ra.session01.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/add")
    public String add(Model model,Category category){
        model.addAttribute("category",category);
        return "category/add";
    }
    @PostMapping("/add")
    public String save(@ModelAttribute("category") Category category){
        if(categoryService.saveOrUpdate(category)!=null){
            return "redirect:/category";
        }
        return "category/add";
    }
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id){
        Category category = categoryService.findById(id);
        model.addAttribute("category",category);
        return "category/edit";
    }
    @PostMapping("/edit/{id}")
    public String update(@ModelAttribute("category") Category category,@PathVariable Long id){
        if(categoryService.saveOrUpdate(category)!=null){
            return "redirect:/category";
        }
        return "redirect:/category/edit/"+id;

    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        categoryService.delete(id);
        return "redirect:/category";
    }
}
