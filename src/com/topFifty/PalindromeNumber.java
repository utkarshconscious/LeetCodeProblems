package com.topFifty;

import java.util.ArrayList;
import java.util.List;

public class PalindromeNumber {

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        List<Integer> list = new ArrayList<>();
        while (true) {
            list.add(x % 10);
            x = x / 10;
            if (x == 0) {
                break;
            }
        }
        for (int i = 0, j = list.size() - 1; i < j; i++, j--) {
            if (list.get(i) != list.get(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121212121));
    }
}
