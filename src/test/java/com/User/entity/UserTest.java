package com.User.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    private User userUnderTest;

    @BeforeEach
    void setUp() {
        userUnderTest = new User();
    }

    @Test
    void testBuild() {
        // Run the test
        final User result = User.build(0, "name", "email", "mobile", "gender", 0, "nationality");
        assertThat(result.getUserId()).isEqualTo(0);
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
        assertThat(userUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(userUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(userUnderTest.hashCode()).isNotNull();
    }

    @Test
    void testToString() {
        assertThat(userUnderTest.toString()).isNotNull();
    }
}
