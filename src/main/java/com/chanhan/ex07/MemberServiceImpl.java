package com.chanhan.ex07;

import org.springframework.dao.DataAccessException;

import java.util.List;

public class MemberServiceImpl  implements MemberService{
    private MemberDAO memberDAO;

    public void setMemberDAO(MemberDAO memberDAO){
        this.memberDAO = memberDAO;
    }

    public List listMembers() throws DataAccessException {
        List memberList = null;
        memberList = memberDAO.selectAllMembers();
        return memberList;
    }
}
