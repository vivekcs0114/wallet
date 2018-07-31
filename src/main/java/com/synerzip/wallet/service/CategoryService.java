package com.synerzip.wallet.service;

import com.synerzip.wallet.model.Category;
import com.synerzip.wallet.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    public Category find(int id) {
        return categoryRepository.getOne(id);
    }

    public  Category update(int id, Category category) {
        Category dbCategory = categoryRepository.getOne(id);
        if(null != dbCategory) {
            if(!StringUtils.isEmpty(category.getName())) {
                dbCategory.setName(category.getName());
            }
        }
        return categoryRepository.save(category);
    }

    public void delete(int id) {
        categoryRepository.deleteById(id);
    }
}
