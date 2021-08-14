package com.topFifty;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        char[] numOne = num1.toCharArray();
        char[] numTwo = num2.toCharArray();
        int[] output = new int[numOne.length + numTwo.length];
        for (int i = numOne.length - 1; i >= 0; i--) {
            for (int j = numTwo.length - 1; j >= 0; j--) {
                int mul = (numOne[i] - '0') * (numTwo[j] - '0');
                int sum = output[i + j + 1] + mul;
                output[i + j + 1] = sum % 10;
                output[i + j] += sum / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int out : output) {
            if (sb.length() != 0 || out != 0) {
                sb.append(out);
            }
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}
