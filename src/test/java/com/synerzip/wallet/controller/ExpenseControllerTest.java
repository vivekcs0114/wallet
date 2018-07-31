package com.synerzip.wallet.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.synerzip.wallet.model.Expense;
import com.synerzip.wallet.model.User;
import com.synerzip.wallet.service.ExpenseService;
import com.synerzip.wallet.service.UserService;
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
@WebMvcTest(ExpenseController.class)
@AutoConfigureMockMvc(secure = false)
public class ExpenseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ExpenseService expenseService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void getExpense_shouldReturnExpense() throws  Exception {
        BDDMockito.given(expenseService.find(ArgumentMatchers.anyInt()))
                .willReturn(new Expense("January Expense", null,
                        null, null, 0, null));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/expenses/33"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("title").value("January Expense"));
    }
}
