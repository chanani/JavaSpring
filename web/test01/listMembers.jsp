<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Spring test</title>
</head>
<body>

<table border="1" width="80%" align="center">
    <tr align="center">
        <td>아이디</td>
        <td>비밀번호</td>
        <td>이름</td>
        <td>이메일</td>
        <td><b>삭제</b></td>
    </tr>
    <c:forEach var="member" items="${membersList}">
        <tr align="center">
            <td>${member.id}</td>
            <td>${member.pwd}</td>
            <td>${member.name}</td>
            <td>${member.email}</td>
            <td>${member.joinDate}</td>
            <td><a href="#{contextPath}/mem.do?action=deleteMember&id=${member.id}">삭제하기</a></td>
        </tr>
    </c:forEach>

</table>

</body>
</html>