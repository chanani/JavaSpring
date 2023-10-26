package com.chanhan.ex04;

import org.springframework.context.support.GenericXmlApplicationContext;

public class CalcTest {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("AOPTest.xml");
        Calculator cal = (Calculator) ctx.getBean("proxyCal");
        cal.add(100, 20);
        System.out.println();
        cal.subtract(100,20);
        System.out.println();
        cal.multiply(100, 20);
        System.out.println();
        cal.divide(100,20);
    }
}
