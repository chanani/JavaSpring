package com.chanhan.member.dao;

import com.chanhan.member.vo.MemberVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.dao.DataAccessException;

import java.util.List;

public class MemberDAOImpl implements MemberDAO{

    private SqlSession sqlSession;

    public void setSqlSession(SqlSession sqlsession){
        this.sqlSession = sqlsession;
    }


    @Override
    public List selectAllMemberList() throws DataAccessException {
        List<MemberVO> membersList = null;
        membersList = sqlSession.selectList("mapper.member.selectAllMemberList");
        return membersList;
    }

    @Override
    public int insertMember(MemberVO memberVO) throws DataAccessException {
        int result = sqlSession.insert("mapper.member.insertMember", memberVO);
        return result;
    }

    @Override
    public int deleteMember(String id) throws DataAccessException {
        int result = sqlSession.insert("mapper.member.deleteMember", id);
        return result;
    }
}
