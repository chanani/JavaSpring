package com.chanhan.member.controller;

import com.chanhan.member.service.MemberService;
import com.chanhan.member.service.MemberServiceImpl;
import com.chanhan.member.vo.MemberVO;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class MemberControllerImpl extends MultiActionController implements MemberController {

    private MemberService memberService;
    public void setMemberService(MemberServiceImpl memberService){
        this.memberService = (MemberService) memberService;
    }

    public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws  Exception{
        String viewName = getViewName(request);
        List<MemberVO> membersList = memberService.listMembers();
        ModelAndView mav = new ModelAndView(viewName);
        mav.addObject("membersList", membersList);
        return mav;
    }

    public ModelAndView addMember(HttpServletRequest request, HttpServletResponse response) throws  Exception{
        request.setCharacterEncoding("utf-8");
        MemberVO memberVO = new MemberVO();
        bind(request, memberVO);
        int result = 0;
        result = memberService.addMember(memberVO);
        ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
        return mav;
    }

    public ModelAndView removeMember(HttpServletRequest request, HttpServletResponse response) throws  Exception{
        request.setCharacterEncoding("utf-8");
        MemberVO memberVO = new MemberVO();
        String id = request.getParameter("id");
        memberService.removeMember(id);
        ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
        return mav;
    }

    public ModelAndView form(HttpServletRequest request, HttpServletResponse response) throws  Exception{
        String viewName = getViewName(request);
        ModelAndView mav = new ModelAndView();
        mav.setViewName(viewName);
        return mav;
    }


    private String getViewName(HttpServletRequest request) throws Exception{ // .do가 아닌 uri + .jsp로 변환
        String contextPath = request.getContextPath();
        String uri = (String) request.getAttribute("javax.servlet.include.request_uri");
        if (uri == null || uri.trim().equals("")){
            uri = request.getRequestURI();
        }

        int begin = 0;
        if (!((contextPath == null) || "".equals(contextPath))){
            begin = contextPath.length();
        }

        int end;
        if (uri.indexOf(";") != -1 ){
            end = uri.indexOf(";");
        } else if (uri.indexOf("?") != -1){
            end = uri.indexOf("?");
        } else {
            end = uri.length();
        }
        String fileName = uri.substring(begin, end);
        if (fileName.indexOf(".") != -1 ){
            fileName = fileName.substring(0, fileName.lastIndexOf("."));
        }

        if (fileName.indexOf("/") != -1 ){
            fileName = fileName.substring(fileName.lastIndexOf("/"), fileName.length());
        }

        return fileName;
    }

}
