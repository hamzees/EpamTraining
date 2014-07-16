<%@ page contentType="text/html; charset=utf-8"  %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Результат парсинга</title>
        <link rel="stylesheet" href="css/style.css" type="text/css">

    </head>
    <body>
        <h3>Результат парсинга: ${res} </h3>        
    <center>
        <div class = "results"><table >
                ${tablebegin}
                <c:forEach var="elem" items="${lst}" varStatus="status">
                    <tr>
                        <td><c:out value="${elem}"/></td>
                    </tr>        
                </c:forEach>
            </table> 
        </div>

    </center>
    <c:import url="\common\footer.jsp" />

</body>
</html>


