package com.example.tikatest;

import java.util.concurrent.*;

public class CompletableFutrueTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = new ThreadPoolExecutor(10,10,60L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(3));
        CompletableFuture<String> task = CompletableFuture.supplyAsync(() -> {
            System.out.println("task1");
            return "task1";
        }, executorService);

        CompletableFuture<Void> task2 = CompletableFuture.runAsync(() -> {
            System.out.println("task2");
        }, executorService);
        System.out.println(task2.get());

        executorService.shutdown();
    }
}
