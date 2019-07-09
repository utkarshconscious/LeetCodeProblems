package com.Strings;

public class RevereStringTwoPointer {

    public String reverseString(String str) {

        if(str==null || str.length()==0)
        return "";
        char [] input = str.toCharArray();
        char temp;
        for(int i=0,j=str.length()-1;i!=j;i++,j--){
            temp=input[i];
            input[i]=input[j];
            input[j]=temp;
        }

        return new String(input);
    }


    public static void main(String [] args){

    }
}
