package com.chanhan.ex03;

public class MemberServiceImpl implements MemberService{
    private MemberDAO memberDAO;
    public void setMemberDAO(MemberDAO memberDAO){
        this.memberDAO = memberDAO;
    }

    @Override
    public void listMember() {
        memberDAO.listMembers();
    }
}
