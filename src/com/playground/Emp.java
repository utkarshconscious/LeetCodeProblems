package com.playground;

public class Emp {


    private Emp(){
        System.out.println("inside constructor");
    }
    private String name = "John";
    private int age = 23;
    private Integer sal = new Integer(5000);
    private Double incentive = new Double("12345.567");
    private boolean isEmployee = true;
}
