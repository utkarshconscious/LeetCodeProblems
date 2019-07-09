package com.HashTable;

public class HappyNumber {

    // Better solution...
    /*public boolean isHappy(int n) {
            if(n == 1) return true;
            int n1 = n;
            while(true){
                n = help(help(n));
                n1 = help(n1);
                if(n1 == 1 || n == 1) return true;
                if(n1 == n && n != 1) return false;
            }
        }
        private int help(int n){
            int temp = 0;
            while(n != 0){
                int tail = n % 10;
                temp += tail * tail;
                n /= 10;
            }
            return temp;
        }*/
    public boolean isHappy(int n) {
        int sum =0;
        boolean flag =true;
      do {
          if(n/10==0)
              flag=false;
            while(n>0){
                sum=sum+(n%10)*(n%10);
                n=n/10;
            }
            n=sum;
            sum=0;

        }while (n/10>0 || flag);
        if(n==1)
            return true;
        return false;
    }

    public static void main(String [] args){
        System.out.println(new HappyNumber().isHappy(19));
    }
}

