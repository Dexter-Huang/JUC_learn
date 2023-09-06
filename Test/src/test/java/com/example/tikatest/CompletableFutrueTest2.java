package com.example.tikatest;

import java.util.concurrent.*;
import java.util.function.Function;
import java.util.function.Supplier;

public class CompletableFutrueTest2 {
    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(10,10,60L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(3));
        Supplier<String> taskA = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("1:"+Thread.currentThread().getName());
            return "taskA";
        };

        Function<String,String> taskB = (s) -> {
            System.out.println("2:"+Thread.currentThread().getName());
            return s+"taskB";
        };

        CompletableFuture<String> future = CompletableFuture.supplyAsync(taskA, executorService).thenApplyAsync(taskB, executorService);
        System.out.println(future.join());
        executorService.shutdown();
    }
}
