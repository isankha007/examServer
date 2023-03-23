package com.exam.controller;

import com.exam.entity.exam.Category;
import com.exam.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/")
    public ResponseEntity<?> addCategory(@RequestBody Category category){
        Category category1=this.categoryService.addCategory(category);
        return new ResponseEntity<>(category1, HttpStatus.CREATED);
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<?> getCategory(@PathVariable("categoryId") Long categoryId){
        Category category1=this.categoryService.getCategory(categoryId);
        return new ResponseEntity<>(category1, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<?> getCategory(){
        Set<Category> categories = this.categoryService.getCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<?> updateCategory(@RequestBody Category category){
        Category category1 = this.categoryService.updateCategory(category);
        return new ResponseEntity<>(category1, HttpStatus.OK);
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<?> deleteCategory(@PathVariable("categoryId") Long categoryId){
        this.categoryService.deleteCategory(categoryId);
        return ResponseEntity.ok("Deleted");
    }

}
