package com.chanhan.ex08;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/mem.do")
public class Memberservlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doHandle(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doHandle(request, response);
    }

    // member list
//    private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("utf-8");
//        response.setContentType("text/html;charset=utf-8");
//        MemberDAO dao = new MemberDAO();
//        List<MemberVO> membersList = dao.selectAllMemberList();
//        request.setAttribute("membersList", membersList);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("test01/listMembers.jsp");
//        dispatcher.forward(request,response);
//    }

    private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        MemberDAO dao = new MemberDAO();
        MemberVO memberVO = new MemberVO();
        String action = request.getParameter("action");
        String nextPage = "";
        if (action == null || action.equals("listMembers")){
            List<MemberVO> membersList = dao.selectAllMemberList();
            request.setAttribute("membersList", membersList);
            nextPage = "test01/memberInfo.jsp";
        } else if (action.equals("selectMemberById")){
            String id = request.getParameter("value");
            memberVO = dao.selectMemberById(id);
            request.setAttribute("member", memberVO);
            nextPage = "test01/memberInfo.jsp";
        } else if (action.equals("selectMemberByPwd")){
            String pwd = request.getParameter("value");
            List<MemberVO> membersList = dao.selectMemberPwd(pwd);
            request.setAttribute("membersList", membersList);
            nextPage = "test01/listMembers.jsp";
        } else if(action.equals("insertMember")){
            String id = request.getParameter("id");
            String pwd = request.getParameter("pwd");
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            memberVO.setId(id);
            memberVO.setPwd(pwd);
            memberVO.setName(name);
            memberVO.setEmail(email);
            dao.insertMember(memberVO);
            nextPage = "/mem.do?action=listMembers";
        } else if(action.equals("updateMember")){
            String id = request.getParameter("id");
            String pwd = request.getParameter("pwd");
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            memberVO.setId(id);
            memberVO.setPwd(pwd);
            memberVO.setName(name);
            memberVO.setEmail(email);
            dao.updateMember(memberVO);
            nextPage = "/mem.do?action=listMembers";
        } else if(action.equals("deleteMember")){
            String id = request.getParameter("id");
            dao.deleteMember(id);
            nextPage = "/mem.do?action=listMembers";
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
        dispatcher.forward(request,response);
    }

}
