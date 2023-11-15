package com.chanhan.ex08;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.util.List;

public class MemberDAO {
    private static SqlSessionFactory sqlMapper = null;
    public static SqlSessionFactory getInstance(){
        if (sqlMapper == null){
            try {
                String resource = "mybatis/SqlMapConfig.xml";
                Reader reader = Resources.getResourceAsReader(resource);
                sqlMapper = new SqlSessionFactoryBuilder().build(reader);
                reader.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return sqlMapper;
    }

    public List<MemberVO> selectAllMemberList(){
        sqlMapper = getInstance();
        SqlSession session = sqlMapper.openSession();
        List<MemberVO> memList = null;
        memList = session.selectList("mapper.member.selectAllMemberList");
        return memList;
    }

    public String selectName(){
        sqlMapper = getInstance();
        SqlSession session = sqlMapper.openSession();
        String name = session.selectOne("mapper.member.selectName");
        return name;
    }

    public String selectPwd(){
        sqlMapper = getInstance();
        SqlSession session = sqlMapper.openSession();
        String pwd = session.selectOne("mapper.member.selectPwd");
        return pwd;
    }

    public MemberVO selectMemberById(String id){
        sqlMapper = getInstance();
        SqlSession session = sqlMapper.openSession();
        MemberVO memberVO = session.selectOne("mapper.member.selectMemberById", id);
        return memberVO;
    }

    public List<MemberVO> selectMemberPwd(String pwd){
        sqlMapper = getInstance();
        SqlSession session = sqlMapper.openSession();
        List<MemberVO> memberList = null;
        memberList = session.selectOne("mapper.member.selectMemberByPwd", pwd);
        return memberList;
    }

    public int insertMember(MemberVO memberVO){
        sqlMapper = getInstance();
        SqlSession session = sqlMapper.openSession();
        int result = 0;
        result = session.insert("mapper.member.insertMember", memberVO);
        session.commit();
        return result;
    }

    public int updateMember(MemberVO memberVO){
        sqlMapper = getInstance();
        SqlSession session = sqlMapper.openSession();
        int result = session.update("mapper.member.updateMember", memberVO);
        session.commit();
        return result;
    }

    public int deleteMember(String id){
        sqlMapper = getInstance();
        SqlSession session = sqlMapper.openSession();
        int result = session.delete("mapper.member.deleteMember", id);
        session.commit();
        return result;
    }

    public List<MemberVO> searchMember(MemberVO memberVO){
        sqlMapper = getInstance();
        SqlSession session = sqlMapper.openSession();
        List<MemberVO> list = session.selectList("mapper.member.searchMember", memberVO);
        return list;
    }

    public List<MemberVO> foreachSelect(List<String> nameList){
        sqlMapper = getInstance();
        SqlSession session = sqlMapper.openSession();
        List<MemberVO> list = session.selectList("mapper.member.foreachSelect", nameList);
        return list;
    }

    public int foreachInsert(List<MemberVO> memList){
        sqlMapper = getInstance();
        SqlSession session = sqlMapper.openSession();
        int result = session.insert("mapper.member.foreachInsert", memList);
        return result;
    }

}
