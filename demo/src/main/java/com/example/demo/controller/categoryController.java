package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/category")
public class categoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/afficher")
    public String showCategory(Model model)
    {
        model.addAttribute("ListCat",categoryService.showAllCategory());
        return "Category/showCategory";
    }
    @PostMapping("/save")
    public String save(Category category)
    {
        categoryService.save(category);
        return "redirect:/category/afficher";
    }
    @GetMapping("/form")
    public String form()
    {
        return "Category/category";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model){
        model.addAttribute("categoryId",categoryService.showOneCategory(id));
        return "Category/modification";
    }
    @PostMapping("/edit")
    public String edit(@ModelAttribute("Editcategory") Category category)
    {
        categoryService.save(category);
        return "redirect:/category/afficher";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id)
    {
        categoryService.delete(id);
        return "redirect:/category/afficher";
    }
}
