package com.example.tikatest;

import com.github.rholder.retry.*;
import com.google.common.base.Predicates;

import java.util.concurrent.TimeUnit;

public class GuavaRetryTest {
    public static void main(String[] args) {
        Retryer<String> retryer = RetryerBuilder.<String> newBuilder()
                // 无论出现什么异常，都进行重试
                .retryIfException()
                // 返回结果等于"error"时重试
                .retryIfResult(Predicates.equalTo("error"))
                // 重试策略：每隔2秒重试一次，最多重试3次
                .withWaitStrategy(WaitStrategies.fixedWait(2, TimeUnit.SECONDS))
                .withStopStrategy(StopStrategies.stopAfterAttempt(3))
                .withRetryListener(new RetryListener() {
                    @Override
                    public <V> void onRetry(Attempt<V> attempt) {
                        System.out.println("RetryListener:第" + attempt.getAttemptNumber()+"次调用");
                    }
                })
                .build();

        try {
            retryer.call(() -> {
                // 模拟异常
                // throw new RuntimeException("exception");
                // 模拟返回结果为"error"
                return "error";
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
