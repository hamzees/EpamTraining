<%-- 
    Document   : error
    Created on : 14.07.2014, 11:46:15
    Author     : apple
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
    </head>
    <body>
        Request from ${pageContext.errorData.requestURI} is failed
        <br/>
        Servlet name or type: ${pageContext.errorData.servletName}
        <br/>
        Status code : ${pageContext.errorData.statusCode}
        <br/>
        Exception : ${pageContext.errorData.throwable}
        
    </body>
</html>
