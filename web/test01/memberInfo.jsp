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

<table border="1" width="100%" align="center">
  <tr align="center" bgcolor="#ff7f50">
    <td>아이디</td>
    <td>비밀번호</td>
    <td>이름</td>
    <td>이메일</td>
  </tr>

  <tr align="center">
    <td>${member.id}</td>
    <td>${member.pwd}</td>
    <td>${member.name}</td>
    <td>${member.email}</td>
    <td>${member.joinDate}</td>
  </tr>

</table>

</body>
</html>