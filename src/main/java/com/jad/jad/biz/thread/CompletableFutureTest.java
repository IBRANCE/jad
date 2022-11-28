package com.jad.jad.biz.thread;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author nice
 * @create 2022/1/25 2:36 下午
 * @desc
 */
public class CompletableFutureTest {

    private static final Logger logger = LoggerFactory.getLogger(CompletableFutureTest.class);

    public static void main(String[] args) throws InterruptedException {
        CompletableFutureTest cft = new CompletableFutureTest();

        // 多任务处理
        cft.handleMultiTask();

        Thread.sleep(10000);
    }

    public void demo1() {
        CompletableFuture.runAsync(() -> {
            // 线程中执行业务逻辑


        });
    }

    public void demo2() throws ExecutionException, InterruptedException, TimeoutException {
        List<String> list = Lists.newArrayList();

        // allOf()方法，所有的线程全部正常执行才能
        CompletableFuture.allOf(list.stream()
                .map((artifact) -> CompletableFuture.runAsync(() -> { // 执行单个线程业务逻辑
                    // 执行业务逻辑
                }))
                .toArray(CompletableFuture[]::new)).get(60, TimeUnit.MINUTES);
    }

    /**
     * 异步处理
     * 分线程和的计算
     */
    public void asyncHandle(List<Integer> subList, AtomicInteger ai) {
        CompletableFuture.supplyAsync(() -> {
            // 执行业务逻辑
            int subSum = 0;
            for (int i = 0; i < subList.size(); i++) {
                subSum += subList.get(i);
            }

            return subSum;
        }).whenComplete((r, e) -> {
            if (e != null) {
                logger.error("async handle occur exception", e);
                return;
            }

            ai.addAndGet(r);
        });
    }

    /**
     * 多任务处理
     * 备注：任务1和任务2是并发执行的，任务3是任务1和2都执行完毕之后才会执行。
     */
    public void handleMultiTask() {
        CompletableFuture.supplyAsync(() -> {
            // 任务1
            logger.info("[handleMultiTask] task 1 start execute");

            for (int i = 0; i < 1000; i++) {
                System.out.println("执行任务1, +" + i);
            }

            logger.info("[handleMultiTask] task 1 end execute");
            return "test";
        }).runAfterBoth(CompletableFuture.runAsync(() -> {
            // 任务2
            logger.info("[handleMultiTask] task 2 start execute");

            for (int i = 1000; i < 2000; i++) {
                System.out.println("执行任务2, +" + i);
            }

            logger.info("[handleMultiTask] task 2 end execute");
        }), () -> {
            // 任务1和2执行完毕后，才执行3
            logger.info("[handleMultiTask] task 3 start execute");

            for (int i = 2000; i < 2500; i++) {
                System.out.println("执行任务3, +" + i);
            }

            logger.info("[handleMultiTask] task 3 end execute");
        });
    }


}
