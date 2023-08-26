package com.example.tikatest.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class RetryService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private final int totalNum = 100000;

    /**
     * 测试业务支持重试
     * @param num
     * @return
     * @throws Exception
     */
    @Retryable(
            value = Exception.class, // 指定异常进行充数
            include = {},// 处理异常
            exclude = {},// 例外异常
            maxAttempts = 3, // 最大重试次数
            backoff = @Backoff( // 重试等待策略
                    delay = 2000L,// 重试间隔
                    multiplier = 1.5// 多次重试间隔系数2 、3、4.5
            )
    )
    public int baseRetry(int num) {
        logger.info("开始执行业务" + LocalTime.now());
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            logger.error("illegal");
        }
        if (num <= 0) {
            throw new IllegalArgumentException("数量不对");
        }
        logger.info("业务执行结束" + LocalTime.now());
        return totalNum - num;
    }

    /**
     * 重试失败后的兜底方法
     * @param e
     * @return
     */
    @Recover
    public int baseRetryRecover(Exception e) {
        logger.warn("业务执行失败！！！" + LocalTime.now());
        logger.warn("异常信息：" + e.getMessage());
        return totalNum;
    }
}

