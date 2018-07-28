package com.synerzip.wallet.service;

import com.synerzip.wallet.model.User;
import com.synerzip.wallet.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Before
    public void setup()throws Exception {
        userService = new UserService(userRepository);
    }

    @Test
    public void findById_returnUser() {
        BDDMockito.given(userRepository.findById(11))
                .willReturn(new User("vivek", "vivek@gmail.com","vivekt123"));
        User found = userService.find(11);
        Assertions.assertThat(found.getName()).isEqualTo("vivek");
    }
}
