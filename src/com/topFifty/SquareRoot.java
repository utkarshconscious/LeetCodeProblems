package com.topFifty;

public class SquareRoot {

    public static int mySqrt(int x) {

        long i = 1;
        long nx = x;
        for (; i <= nx; i++) {
            if (i * i == nx) {
                return (int) i;
            } else if (i * i > nx) {
                return (int) (i - 1);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(Integer.MAX_VALUE));
    }
}
