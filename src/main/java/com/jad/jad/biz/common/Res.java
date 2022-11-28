package com.jad.jad.biz.common;

public record Res(int code, String msg) {

    public static Res getInstance() {
        return new Res(200, "success");
    }

}
