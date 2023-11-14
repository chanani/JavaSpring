<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원 검색창</title>
</head>
<body>

<form method="post" action="${contextPath}/mem.do?action=insertMember">
   <h1 class="text_center">회원가입</h1>
    <teble align="center">
        <tr>
            <td width="200"><p align="right">아이디</p></td>
            <td width="200"><input type="text" name="id"></td>
        </tr>
        <tr>
            <td width="200"><p align="right">비밀번호</p></td>
            <td width="200"><input type="password" name="pwd"></td>
        </tr>
        <tr>
            <td width="200"><p align="right">이름</p></td>
            <td width="200"><input type="text" name="name"></td>
        </tr>
        <tr>
            <td width="200"><p align="right">이메일</p></td>
            <td width="200"><input type="text" name="email"></td>
        </tr>
        <input type="submit" value="가입하기">
    </teble>

</form>


</body>
</html>