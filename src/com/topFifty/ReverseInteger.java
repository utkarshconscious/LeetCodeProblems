package com.topFifty;

public class ReverseInteger {
    public static int reverse(int x) {
        long xx = x;
        long output = reverseLong(xx);
        if (output >= Integer.MAX_VALUE || output <= Integer.MIN_VALUE){
            return 0;
        }
        return (int)output;
    }

    private static long reverseLong(long num) {
        long output = 0;

        while (true) {
            long temp = num % 10;
            output = output * 10 + temp;
            num = num / 10;
            if (num == 0) {
                break;
            }
        }

        return output;
    }

    public static void main(String [] args){
        System.out.println(Integer.MAX_VALUE);
        System.out.println(reverse(-120));
    }
}
