package com.User.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserRequestTest {

    private UserRequest userRequestUnderTest;

    @BeforeEach
    void setUp() {
        userRequestUnderTest = new UserRequest();
    }

    @Test
    void testBuild() {
        // Run the test
        final UserRequest result = UserRequest.build("name", "email", "mobile", "gender", 0, "nationality");
        assertThat(result.getName()).isEqualTo("name");
        assertThat(result.getEmail()).isEqualTo("email");
        assertThat(result.getMobile()).isEqualTo("mobile");
        assertThat(result.getGender()).isEqualTo("gender");
        assertThat(result.getAge()).isEqualTo(0);
        assertThat(result.getNationality()).isEqualTo("nationality");
        assertThat(result.equals("o")).isFalse();
        assertThat(result.hashCode()).isNotNull();
        assertThat(result.toString()).isNotNull();
    }

    @Test
    void testEquals() {
        assertThat(userRequestUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(userRequestUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(userRequestUnderTest.hashCode()).isNotNull();
    }

    @Test
    void testToString() {
        assertThat(userRequestUnderTest.toString()).isNotNull();
    }
}
