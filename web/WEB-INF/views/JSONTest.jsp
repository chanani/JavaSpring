<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
    $(function(){
        $("#checkJson").click(function(){
            var article = {
                articleNO : "144",
                writer : "박지성",
            title : "안녕하세요.",
            content : "상품 소개 글입니다."
            };
            $.ajax({
                type : "POST",
                url : "${contextPath}/boards",
                contentType : "application/json",
                data : JSON.stringify(article),
                success : function(data, textStatus){
                    alert(data);
                },
                error : function(data, textStatus){
                    alert("에러가 발생했습니다.")
                },
                complete : function (data, textStatus){

                }
            });
        });
    });
</script>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Spring test</title>
</head>
<body>

<input type="button" id="checkJson" value="새글 쓰기"/><br><br>
<div id="output"></div>

</body>
</html>