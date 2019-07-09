package com.Strings;

public class AddBinaryJavaAPI {

    public String addBinaryAPI(String b1, String b2){
        int len1 = b1.length();
        int len2 = b2.length();
        int carry = 0;
        String res = "";
        // the final length of the result depends on the bigger length between b1
        // and b,
        // (also the value of carry, if carry = 1, add "1" at the head of result,
        // otherwise)
        int maxLen = Math.max(len1, len2);
        for (int i = 0; i < maxLen; i++) {

            // start from last char of String b1 and b2
            // notice that left side is an int and right side is char
            // so we need to minus the decimal value of '0'
            int p = i < len1 ? b1.charAt(len1 - 1 - i) -'0' : 0;
            int q = i < len2 ? b2.charAt(len2 - 1 - i) -'0': 0;

            int tmp = p + q + carry;
            carry = tmp / 2;
            res = tmp % 2 + res;
        }
        return (carry == 0) ? res : "1" + res;
    }

    public static void main(String [] args){
        String a = "11111111111111111", b = "1111111111111111111111111";

        System.out.println("output: "+new AddBinaryJavaAPI().addBinaryAPI(a,b));
    }
}
