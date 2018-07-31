package com.synerzip.wallet.service;

import com.synerzip.wallet.model.Category;
import com.synerzip.wallet.repository.CategoryRepository;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

@RunWith(MockitoJUnitRunner.class)
public class CategoryServiceTest {

    @Autowired
    private CategoryService categoryService;

    @Mock
    private CategoryRepository categoryRepository;

    @Before
    public void setup()throws Exception {
        categoryService = new CategoryService(categoryRepository);
    }

    @Test
    public void findById_returnCategory() {
        Category category = new Category(22,"Electronics");
        BDDMockito.given(categoryRepository.getOne(22)).willReturn(category);
        Category found = categoryService.find(22);
        Assertions.assertThat(found.getName()).isEqualTo("Electronics");
    }
}
