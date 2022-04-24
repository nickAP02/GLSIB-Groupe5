package com.example.demo.service;

import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    public void save(Category category){
        categoryRepository.save(category);
    }

    public List<Category> showAllCategory(){
        return categoryRepository.findAll();
    }

    public Category showOneCategory(int id){
       return categoryRepository.findById(id).get();
    }
    public void delete(int id)
    {
        if(showOneCategory(id)!=null)
            categoryRepository.deleteById(id);
    }
}
