package com.chanhan.member.dao;

import com.chanhan.member.vo.MemberVO;

import java.util.List;

public interface MemberDAO {

    public List selectAllMemberList();
    public int insertMember(MemberVO memberVO);
    public int deleteMember(String id);


}
