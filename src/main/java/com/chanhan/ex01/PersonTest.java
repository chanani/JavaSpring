package com.chanhan.ex01;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class PersonTest {
    public static void main(String[] args) {
        // BeanFactory factory = new XmlBeanFactory(new FileSystemResource("person.xml"));
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("person.xml");
        // GenericXmlApplicationContext를 사용해야 resource 밑에있는 xml을 불러올 수 있음

        PersonService person = (PersonService) ctx.getBean("personService");
        person.sayHello();

    }
}
