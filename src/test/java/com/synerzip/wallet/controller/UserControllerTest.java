package com.synerzip.wallet.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.synerzip.wallet.model.User;
import com.synerzip.wallet.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void getUser_shouldReturnUser() throws  Exception {
        BDDMockito.given(userService.find(ArgumentMatchers.anyInt()))
                .willReturn(new User("vivek", "vivek@gmail.com", "vivekt123"));
        mockMvc.perform(MockMvcRequestBuilders.get("/api/users/11"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("name").value("vivek"));
    }

    @Test
    public void createUser_shouldReturnUser() throws  Exception {
        User user = new User();
        BDDMockito.given(userService.create(user))
                .willReturn(new User(11,"vivek", "vivek@gmail.com", "vivekt123"));
        mockMvc.perform(MockMvcRequestBuilders.post("/api/users").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
