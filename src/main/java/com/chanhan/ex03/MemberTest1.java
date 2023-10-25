package com.chanhan.ex03;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MemberTest1 {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("member.xml");
        MemberService service = (MemberService) ctx.getBean("memberService");
        service.listMember();
    }
}
