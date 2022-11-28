package com.jad.jad.biz.common.util;

import com.jad.jad.biz.common.Res;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

public class HttpUtil {

    private static final Logger logger = LoggerFactory.getLogger(HttpUtil.class);


    private final OkHttpClient httpClient = new OkHttpClient().newBuilder()
            .callTimeout(Duration.ofMillis(1000))
            .build();



    /**
     * 同步发送请求
     */
    public Res syncPost(String url, String body) {
        Request request = new Request.Builder()
                .url(url)
                .headers(Headers.of("Content-Type", "application/json", "Accept", "application/json"))
                .post(RequestBody.create(body.getBytes(StandardCharsets.UTF_8)))
                .build();

        try {
            try (Response response = httpClient.newCall(request).execute()) {
                if (response.isSuccessful()) {

                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return Res.getInstance();
    }


    /**
     * 异步发送请求
     *
     * @return res
     */
    public Res asyncSendReq(String postUrl, String body) {
        logger.info("start async send request, url={}, body={}", postUrl, body);

        Request request = new Request.Builder()
                .url(postUrl)
                .headers(Headers.of("Content-Type", "application/json", "Accept", "application/json"))
                .post(RequestBody.create(body.getBytes(StandardCharsets.UTF_8)))
                .build();

        httpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                if (response.isSuccessful()) {
                    response.body().string();
                }
            }
        });

        return Res.getInstance();
//        return CompletableFuture.supplyAsync(() -> {
//            // 执行业务逻辑
//                System.out.println(Thread.currentThread().getName() + "async_test");
//            return "test";
//        }).whenComplete((r, e)-> {
//            if (e != null) {
//                System.out.println("发生异常情况，请关注");
//            }
//
//            System.out.println(Thread.currentThread().getName() + "async返回结果为" + r);
//
//            System.out.println(Thread.currentThread().getName() + "==========end async=============");
//        });

    }
    
}
