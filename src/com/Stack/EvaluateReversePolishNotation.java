package com.Stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {

        if (tokens.length==0)
            return 0;
        if (tokens.length==1)
            return Integer.parseInt(tokens[0]);

        Stack<Integer> stack = new Stack<>();

        for (int i =0; i<tokens.length;i++){

            if(tokens[i].equals("+")||tokens[i].equals("-")||tokens[i].equals("/")||tokens[i].equals("*")){

                int two=stack.pop();
                int one=stack.pop();
                if(tokens[i].equals("+"))
                    stack.push(one+two);
                else if(tokens[i].equals("-"))
                    stack.push(one-two);
                else if(tokens[i].equals("/"))
                    stack.push(one/two);
                else if(tokens[i].equals("*"))
                    stack.push(one*two);

            }
            else{
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        if(!stack.isEmpty())
            return stack.pop();
        else
            return 0;
    }

    public static void main (String []args){
        String [] input = {"2","1","+","3","*"};

        System.out.println(new EvaluateReversePolishNotation().evalRPN(input));
    }

}
