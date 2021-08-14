package com.topFifty;

public class XToPowerN {

    public static double myPow(double x, int n) {
        double out = 1;
        long nn = n;
        if (nn < 0) {
            nn = -1 * nn;
        }
        while (nn > 0) {
            if (nn % 2 == 1) {
                out = out * x;
                nn--;
            } else {
                x = x * x;
                nn = nn / 2;
            }
        }
        if (n < 0) {
            out = 1 / out;
        }

        return out;
    }


    public static void main(String[] args) {
        System.out.println(myPow(2, -5));
    }
}
