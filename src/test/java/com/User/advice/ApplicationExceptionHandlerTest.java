package com.User.advice;

import com.User.exception.UserNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.lang.reflect.Method;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class ApplicationExceptionHandlerTest {

    private ApplicationExceptionHandler applicationExceptionHandlerUnderTest;

    @BeforeEach
    void setUp() {
        applicationExceptionHandlerUnderTest = new ApplicationExceptionHandler();
    }


    @Test
    void testHandleBusinessException() {
        // Setup
        final UserNotFoundException ex = new UserNotFoundException("message");
        final Map<String, String> expectedResult = Map.ofEntries(Map.entry("value", "value"));

        // Run the test
        final Map<String, String> result = applicationExceptionHandlerUnderTest.handleBusinessException(ex);

        // Verify the results
        assertThat(result).isNotNull();
    }
}
