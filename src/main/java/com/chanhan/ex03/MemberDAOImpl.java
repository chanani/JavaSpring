package com.chanhan.ex03;

import java.util.List;

public class MemberDAOImpl implements MemberDAO{

    @Override
    public void listMembers() {
        System.out.println("listMember 메서드 호출");
        System.out.println("회원정보를 조회합니다.");
    }
}
