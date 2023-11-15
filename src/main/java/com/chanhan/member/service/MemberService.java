package com.chanhan.member.service;

import com.chanhan.member.vo.MemberVO;

import java.util.List;

public interface MemberService {

    public List<MemberVO> listMembers();
    public int addMember(MemberVO memberVO);
    public int removeMember(String id);
}
