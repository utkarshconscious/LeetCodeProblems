package com.topFifty;


public class DivideTwoIntegers {

    public static int divide(int dividend, int divisor) {

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int a = Math.abs(dividend);
        int b = Math.abs(divisor);
        int res = 0;
        while (a - b >= 0) {
            int x = 0;
            while (a - (b << 1 << x) >= 0) {
                x++;
            }
            res += 1 << x;
            a = a - (b << x);
        }

        return (dividend >= 0) == (divisor >= 0) ? res : -1 * res;
    }

    public static void main(String[] args) {
        System.out.println(10<<1<<4);
        System.out.println(10<<5);
        System.out.println(divide(1100540749
                , -1090366779));
    }
}
