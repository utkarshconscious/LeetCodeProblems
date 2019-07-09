package com.codility;

public class SliceOfArray {

    public int solution(int[] A) {
        // write your code in Java SE 8
        if(A.length<=2){
            return A.length;
        }


        int maxLength = 2;

        for (int i=0;i<A.length-1;i++){
            int itemOne = A[i];
            int itemTwo = A[i+1];
            int loopLength=2;
            for(int j=i+2;j<A.length;j++){

                if(A[j]!=itemOne && A[j]!=itemTwo && itemOne!=itemTwo){
                    if(loopLength>maxLength)
                        maxLength=loopLength;
                    break;
                }
                else if(A[j]!=itemOne && A[j]!=itemTwo && itemOne==itemTwo){
                    loopLength++;
                    itemTwo=A[j];
                }
                else if(A[j]==itemOne||A[j]==itemTwo){
                    loopLength++;
                }


            }
            if(loopLength>maxLength)
                maxLength=loopLength;

        }

            return maxLength;

    }

    public static void main (String [] args){
        int [] nums = {1,2,1,1,1,1,1,3};
        System.out.println(new SliceOfArray().solution(nums));
    }
}
