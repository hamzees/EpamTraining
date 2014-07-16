<%-- 
    Document   : login
    Created on : 14.07.2014, 14:04:23
    Author     : apple
--%>

<%@page language = "java" contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Вход</title>
        <link rel="stylesheet" href="css/style.css" type="text/css">

    </head>
    <body>
    <center>   <form name ="LoginForm" method="POST" action="gemstonesparsing">
            <input type="hidden" name="command" value="Login" />
            Введите имя пользователя:<br/>
            <input type="text" name="login" value=""/>
            <br/>Введите пароль:<br/>
            <input type="password" name="password" value=""/>
            ${errorLoginPassMessage}
            <br/>
            ${wrongAction}
            ${nullPage}
            <input type="submit" value="Войти"/>
        </form><hr/> </center>
            <c:import url="\common\footer.jsp" />
</body>
</html>
