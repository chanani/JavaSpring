package com.chanhan.ex08;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
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

    private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        MemberDAO dao = new MemberDAO();
        List<MemberVO> membersList = dao.selectAllMemberList();
        request.setAttribute("membersList", membersList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("test01/listMembers.jsp");
        dispatcher.forward(request,response);
    }
}
