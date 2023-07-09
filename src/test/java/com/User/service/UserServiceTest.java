package com.User.service;

import com.User.dto.UserRequest;
import com.User.entity.User;
import com.User.exception.UserNotFoundException;
import com.User.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository mockRepository;

    @InjectMocks
    private UserService userServiceUnderTest;

    @Test
    void testSaveUser() {
        // Setup
        final UserRequest userRequest = new UserRequest();
        final User expectedResult = new User();
        when(mockRepository.save(new User())).thenReturn(new User());

        // Run the test
        final User result = userServiceUnderTest.saveUser(userRequest);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testGetALlUsers() {
        // Setup
        final List<User> expectedResult = List.of(new User());
        when(mockRepository.findAll()).thenReturn(List.of(new User()));

        // Run the test
        final List<User> result = userServiceUnderTest.getALlUsers();

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testGetALlUsers_UserRepositoryReturnsNoItems() {
        // Setup
        when(mockRepository.findAll()).thenReturn(Collections.emptyList());

        // Run the test
        final List<User> result = userServiceUnderTest.getALlUsers();

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }

    @Test
    void testGetUser() throws Exception {
        // Setup
        final User expectedResult = new User();
        when(mockRepository.findByUserId(0)).thenReturn(new User());

        // Run the test
        final User result = userServiceUnderTest.getUser(0);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testGetUser_UserRepositoryReturnsNull() {
        // Setup
        when(mockRepository.findByUserId(0)).thenReturn(null);

        // Run the test
        assertThatThrownBy(() -> userServiceUnderTest.getUser(0)).isInstanceOf(UserNotFoundException.class);
    }
}
