package com.book.util;

import java.util.Random;

public class RandomStringUtil {
    public static String generateRandomString() {
        Random random = new Random();
        int randomNumber = random.nextInt(90000) + 10000; // số ngẫu nhiên từ 10000 đến 99999
        return String.valueOf(randomNumber);
    }
}

