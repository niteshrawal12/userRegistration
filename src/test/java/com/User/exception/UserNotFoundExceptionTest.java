package com.User.exception;

import org.junit.jupiter.api.BeforeEach;

class UserNotFoundExceptionTest {

    private UserNotFoundException userNotFoundExceptionUnderTest;

    @BeforeEach
    void setUp() {
        userNotFoundExceptionUnderTest = new UserNotFoundException("message");
    }
}
