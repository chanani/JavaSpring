package com.chanhan.ex02;

import org.springframework.context.support.GenericXmlApplicationContext;

public class PersonTest {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("person.xml");
        // GenericXmlApplicationContext를 사용해야 resource 밑에있는 xml을 불러올 수 있음
        PersonService person1 = (PersonService) ctx.getBean("personService1");
        person1.sayHello();

        PersonService person2 = (PersonService) ctx.getBean("personService2");
        person2.sayHello();
    }
}
