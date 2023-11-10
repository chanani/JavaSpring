<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Spring test</title>
</head>
<body>

<form  method="post" action="${contextPath}/test/memberInfo.do">
    <h1 class="text_center">회원가입창</h1>
    <table align="center">
        <tr>
            <td width="200"><p align="right">아이디</p></td>
            <td width="400"><input type="text" name="id"></td>
        </tr>
        <tr>
            <td width="200"><p align="right">비밀번호</p></td>
            <td width="400"><input type="password" name="pwd"></td>
        </tr>
        <tr>
            <td width="200"><p align="right">이름</p></td>
            <td width="400"><input type="text" name="name"></td>
        </tr>
        <tr>
            <td width="200"><p align="right">이메일</p></td>
            <td width="400"><input type="text" name="email"></td>
        </tr>
        <tr>
            <input type="submit" value="가입하기">
            <input type="reset" value="다시입력">
        </tr>

    </table>

</form>

</body>
</html>