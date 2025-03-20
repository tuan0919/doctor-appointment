package nlu.com.app;

import nlu.com.app.tester.ITestService;
import nlu.com.app.tester.TestController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@WebMvcTest(TestController.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class TestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ITestService testService;

    @Autowired
    private TestController testController;  // Inject controller

    @BeforeEach
    void setUp() {
        testService = Mockito.mock(ITestService.class);
        // Inject mock vào controller thông qua reflection hoặc constructor
        ReflectionTestUtils.setField(testController, "testService", testService);
    }

    @Test
    void testSum_withValidParams_shouldReturnCorrectSum() throws Exception {
        // Arrange
        int a = 5;
        int b = 3;
        when(testService.sum(a, b)).thenReturn(8);

        // Act & Assert
        mockMvc.perform(get("/test/sum")
                        .param("a", String.valueOf(a))
                        .param("b", String.valueOf(b)))
                .andExpect(status().isOk())
                .andExpect(content().string("8"));
    }

    @Test
    void testSum_withNegativeNumbers_shouldReturnCorrectSum() throws Exception {
        // Arrange
        int a = -2;
        int b = -3;
        when(testService.sum(a, b)).thenReturn(-5);

        // Act & Assert
        mockMvc.perform(get("/test/sum")
                        .param("a", String.valueOf(a))
                        .param("b", String.valueOf(b)))
                .andExpect(status().isOk())
                .andExpect(content().string("-5"));
    }

    @Test
    void testSum_withMissingParams_shouldReturnBadRequest() throws Exception {
        // Act & Assert
        mockMvc.perform(get("/test/sum")
                        .param("a", "5"))  // Thiếu param b
                .andExpect(status().isBadRequest());
    }

    @Test
    void testSum_withInvalidParams_shouldReturnBadRequest() throws Exception {
        // Act & Assert
        mockMvc.perform(get("/test/sum")
                        .param("a", "invalid")  // Giá trị không phải số
                        .param("b", "3"))
                .andExpect(status().isBadRequest());
    }
}