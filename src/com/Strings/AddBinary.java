package com.Strings;

public class AddBinary {

    public String addBinary(String a, String b) {
        char [] ch1 = a.toCharArray();
        char [] ch2 = b.toCharArray();
        int count =0;
        char [] output;

        int indexch1=0,intdexch2=0;
        if (ch1.length>ch2.length)
            output = new char[ch1.length+1];
        else
            output = new char[ch2.length+1];
        char carry = '0';
        System.out.println("length: "+output.length);
        int i=ch1.length-1, j=ch2.length-1,outIndex=output.length-1;
        for (;i>=0&& j>=0;i--,j--,outIndex--){
            if (ch1[i]!=ch2[j]) {
                if(carry =='1') {
                    output[outIndex] = '0';
                }
                else
                    output[outIndex] = '1';
            }
            else if(ch1[i]=='1'){
                if(carry =='1') {
                    output[outIndex] = '1';
                }
                else {
                    output[outIndex] = '0';
                    carry = '1';
                }
            }
            else {
                if(carry =='1') {
                    output[outIndex] = '1';
                    carry = '0';
                }
                else {
                    output[outIndex] = '0';
                }
            }

            System.out.println("Inter output: "+output[outIndex]);
        }

        while(i>=0){
            System.out.println("i is: "+i);
            if(ch1[i]==carry&& carry=='1') {
                output[outIndex] = '0';
            }
            else if(ch1[i]==carry&& carry=='0')
                output[outIndex] = '0';
            else {
                output[outIndex] = '1';
                carry='0';
            }
            i--;outIndex--;
        }
        while(j>=0){
            if(ch2[j]==carry&& carry=='1') {
                output[outIndex] = '0';
            }
            else if(ch2[j]==carry&& carry=='0')
                output[outIndex] = '0';
            else {
                output[outIndex] = '1';
                carry='0';
            }
            j--;outIndex--;
        }
            if(carry=='1')
            output[outIndex] = carry;
        return new String(output).trim();
    }

    public static void main(String [] args){
        String a = "0", b = "0";

        System.out.println("output: "+new AddBinary().addBinary(a,b));
    }
}
