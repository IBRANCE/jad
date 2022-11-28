package com.jad.jad.biz.common.regex;

import java.io.Console;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtil {

    // 匹配重复或连续的数字/字母
    private static final String regex = "(?!.*?([a-zA-Z0-9])\1+.*$)[a-zA-Z0-9]{6,12}";
    
    public static void main(String[] args) {

        while(true) {
            String input = new Scanner(System.in).nextLine();

            if ("exit".equals(input)) {
                break;
            }

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);
            
            System.out.println("是否匹配" + matcher.matches());
        }
    }

}
