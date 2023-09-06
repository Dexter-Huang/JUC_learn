package com.example.tikatest;

import com.example.tikatest.service.RetryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SpringRetryTest {
    @Autowired
    private RetryService retryService;

    @Test
    public void testRetry() {
        retryService.baseRetry(5);
        retryService.baseRetryRecover(new RuntimeException("test"));
    }

}
