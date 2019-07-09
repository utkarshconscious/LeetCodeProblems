package com.Strings;

public class MatchingString {

    public int strStr(String haystack, String needle) {
        char [] haystachArr = haystack.toCharArray();
        char [] needleArr = needle.toCharArray();
        if(haystachArr.length==0 || needleArr.length==0)
            return 0;

        for(int i=0;i<haystachArr.length;i++){
            int j=0;
            for(;j<needleArr.length&&i+j<haystachArr.length;j++){
                if(haystachArr[i+j]!=needleArr[j])
                    break;
            }
            if (j==needleArr.length)
                return i;
        }
        return -1;
    }
    public static void main(String [] args){
        String a = "aaaaa", b = "bba";
        //System.out.println("output: "+new MatchingString().strStr(a,b));
        System.out.println(mod(10,3));
    }


    public static int mod(int a, int b){
        return a%b;
    }
}
