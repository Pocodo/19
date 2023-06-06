package com.example9.services;

import com.example9.entity.Category;
import com.example9.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    public List<Category> getAllCategories() { return categoryRepository.findAll(); }
    public  Category getCategoryById(Integer id){
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()){
            return optionalCategory.get();
        }else {
            throw new RuntimeException("Category not found");
        }
    }
    public void addCategory(Category category){
        categoryRepository.save(category);
    }
    public void updateCategory(Category category){
        categoryRepository.save(category);
    }
    public  Category saveCategory(Category category){
        return categoryRepository.save(category);
    }

    public void deleteCategory(Integer id){categoryRepository.deleteById(id);}

}