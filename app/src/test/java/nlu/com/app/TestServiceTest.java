package nlu.com.app;

import nlu.com.app.tester.TestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class TestServiceTest {

    @Autowired
    private TestService testService;

    @Test
    void testSum_withPositiveNumbers_shouldReturnCorrectSum() {
        // Arrange
        int a = 5;
        int b = 3;
        int expected = 8;

        // Act
        int result = testService.sum(a, b);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    void testSum_withNegativeNumbers_shouldReturnCorrectSum() {
        // Arrange
        int a = -2;
        int b = -3;
        int expected = -5;

        // Act
        int result = testService.sum(a, b);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    void testSum_withZeroAndPositiveNumber_shouldReturnCorrectSum() {
        // Arrange
        int a = 0;
        int b = 7;
        int expected = 7;

        // Act
        int result = testService.sum(a, b);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    void testSum_withPositiveAndNegativeNumber_shouldReturnCorrectSum() {
        // Arrange
        int a = 5;
        int b = -3;
        int expected = 2;

        // Act
        int result = testService.sum(a, b);

        // Assert
        assertEquals(expected, result);
    }
}