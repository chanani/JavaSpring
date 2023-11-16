package com.chanhan.member.service;

import com.chanhan.member.controller.MemberController;
import com.chanhan.member.dao.MemberDAO;
import com.chanhan.member.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

    @Autowired
   private MemberDAO memberDAO;

   public void setMemberDAO(MemberDAO memberDAO){
       this.memberDAO = memberDAO;
   }
   public List<MemberVO> listMembers() throws DataAccessException {
       List<MemberVO> membersList = null;
       membersList = memberDAO.selectAllMemberList();
       return membersList;
   }

   public int addMember(MemberVO memberVO) throws DataAccessException{
       return memberDAO.insertMember(memberVO);
   }

   public int removeMember(String id) throws DataAccessException {
       return memberDAO.deleteMember(id);
   }

}
