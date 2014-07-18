<%@page language = "java" contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
    </head>
    <body>
       <c:import url="\common\header.jspf" />
        Request from ${pageContext.errorData.requestURI} is failed
        <br/>
        Servlet name or type: ${pageContext.errorData.servletName}
        <br/>
        Status code : ${pageContext.errorData.statusCode}
        <br/>
        Exception : ${pageContext.errorData.throwable}
                    <c:import url="\common\footer.jspf" />

    </body>
</html>
