package com.synerzip.wallet.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.synerzip.wallet.model.Category;
import com.synerzip.wallet.service.CategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@WebMvcTest(CategoryController.class)
@AutoConfigureMockMvc(secure = false)
public class CategoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CategoryService categoryService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void getCategory_shouldReturnCategory() throws  Exception {
        BDDMockito.given(categoryService.find(ArgumentMatchers.anyInt()))
                .willReturn(new Category(22, "Electronics"));
        mockMvc.perform(MockMvcRequestBuilders.get("/api/categories/22"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("name").value("Electronics"));
    }
}
