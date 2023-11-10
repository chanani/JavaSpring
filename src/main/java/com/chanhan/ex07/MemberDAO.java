package com.chanhan.ex07;

import java.util.List;

public interface MemberDAO {
    public List selectAllMembers();
    public int addMember(MemberVO memberVO);
}
