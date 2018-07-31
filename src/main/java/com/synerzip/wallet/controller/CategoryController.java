package com.synerzip.wallet.controller;

import com.synerzip.wallet.model.Category;
import com.synerzip.wallet.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public Category create(Category category) {
        return categoryService.create(category);
    }

    @GetMapping("/{id}")
    public Category find(@PathVariable("id") int id) {
        return categoryService.find(id);
    }

    @PutMapping("/{id}")
    public Category update(@PathVariable("id") int id, @RequestBody Category category) {
        return categoryService.update(id, category);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        categoryService.delete(id);
    }
}
