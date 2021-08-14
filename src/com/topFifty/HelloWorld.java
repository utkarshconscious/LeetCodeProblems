package com.topFifty;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class HelloWorld {

    public static void main(String[] args) {
        System.out.println("Hello World");
        List<String> stringList = new ArrayList<String>();

        stringList.add("One flew over the cuckoo's nest");
        stringList.add("To kill a muckingbird");
        stringList.add("Gone with the wind");

        Stream<String> stream = stringList.stream();

        Optional<String> reduced = stream.reduce((value, combinedValue) -> {
            return combinedValue + " + " + value;
        });

        System.out.println(reduced.get());
        System.out.println(longestPalindrome("abadfaba"));
    }

    public static String longestPalindrome(String s) {
        char arr[] = s.toCharArray();
        if(arr.length<2){
            return  String.valueOf(arr);
        }

        char reverse[] = new char[arr.length];
        char temp[] = new char[arr.length];
        char output[] = new char[arr.length];

        int k = 0;
        int outLen = 0;
        for (int i = 0, j = arr.length - 1; i < arr.length; i++, j--) {
            reverse[j] = arr[i];
        }
        System.out.println(reverse);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == reverse[i]) {
                temp[k++] = arr[i];
                if(k==i){
                    output=temp;
                    break;
                }
            } else {
                if (k > outLen) {
                    output = temp;
                    outLen = k;

                } else {
                    temp = new char[arr.length];
                }
                k=0;
            }
        }

        int counter = 0;
        for (int i = 0; i < output.length; i++) {
            if(output[i]!= '\u0000' ){
            counter++;
            }
        }
        System.out.println("counter: "+counter);

        if(counter<2){
            return String.valueOf(arr[0]);
        }
        char outputArr[] = new char[counter];
        for (int i = 0; i < counter; i++) {
            outputArr[i] = output[i];
        }
        return  String.valueOf(outputArr);
    }
}
