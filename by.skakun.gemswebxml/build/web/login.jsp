<%-- 
    Document   : login
    Created on : 14.07.2014, 14:04:23
    Author     : apple
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
    <center>   <form name ="LoginForm" method="POST" action="gemstonesparsing">
            <input type="hidden" name="command" value="Login" />
            Login:<br/>
            <input type="text" name="login" value=""/>
            <br/>Password:<br/>
            <input type="password" name="password" value=""/>
            ${errorLoginPassMessage}
            ${wrongAction}
            ${nullPage}
            <input type="submit" value="Log in"/>
        </form><hr/> </center>
    </body>
</html>
