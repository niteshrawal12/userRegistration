package com.User.controller;

import com.User.dto.UserRequest;
import com.User.entity.User;
import com.User.exception.UserNotFoundException;
import com.User.repository.UserRepository;
import com.User.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Mock
    private UserService mockService;
    @InjectMocks
    private UserController userControllerUnderTest;

    @Test
    void testSaveUser() {
        final UserRequest userRequest = new UserRequest();
        // Run the test
        final ResponseEntity<User> expectedResult = new ResponseEntity<>(new User(), HttpStatus.CREATED);
        when(mockService.saveUser(new UserRequest())).thenReturn(new User());
        final ResponseEntity<User> result = userControllerUnderTest.saveUser(userRequest);
        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testGetAllUsers() {
        // Setup
        final ResponseEntity<List<User>> expectedResult = new ResponseEntity<>(List.of(new User()), HttpStatus.OK);
        when(mockService.getALlUsers()).thenReturn(List.of(new User()));

        // Run the test
        final ResponseEntity<List<User>> result = userControllerUnderTest.getAllUsers();

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testGetAllUsers_UserServiceReturnsNoItems() {
        // Setup
        when(mockService.getALlUsers()).thenReturn(Collections.emptyList());

        // Run the test
        final ResponseEntity<List<User>> result = userControllerUnderTest.getAllUsers();

        // Verify the results
        assertThat(result).isEqualTo(ResponseEntity.ok(Collections.emptyList()));
    }

    @Test
    void testGetUser() throws Exception {
        // Setup
        final ResponseEntity<User> expectedResult = new ResponseEntity<>(new User(), HttpStatus.OK);
        when(mockService.getUser(0)).thenReturn(new User());

        // Run the test
        final ResponseEntity<User> result = userControllerUnderTest.getUser(0);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testGetUser_UserServiceThrowsUserNotFoundException() throws Exception {
        // Setup
        when(mockService.getUser(0)).thenThrow(UserNotFoundException.class);

        // Run the test
        assertThatThrownBy(() -> userControllerUnderTest.getUser(0)).isInstanceOf(UserNotFoundException.class);
    }
}
