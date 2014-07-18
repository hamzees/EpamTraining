<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Задание 3 - XML-парсеры</title>
        <link rel="stylesheet" href="css/style.css" type="text/css">
    </head>
    <body>
    <c:import url="\common\header.jspf" />
    <center>   <h2>Здравствуйте, ${user} </h2>
        Выберите тип действия:
        <form name = "sax" action="gemstonesparsing" method="POST">
            <input type ="hidden" name="command" value="SAX" />
            <input type ="submit" name="button" value="SAX-парсер" /> 
            <br/>
            ${errorLoginPassMessage}
            ${wrongAction}
            ${nullPage}
        </form>
        <form name = "stax" action="gemstonesparsing" method="POST">
            <input type ="hidden" name="command" value="STAX" />
            <input type ="submit" name="button" value="STAX-парсер" /> 
            <br/>
            ${errorLoginPassMessage}
            ${wrongAction}
            ${nullPage}
        </form>
        <form name = "dom" action="gemstonesparsing" method="POST">
            <input type ="hidden" name="command" value="DOM" />
            <input type ="submit" name="button" value="DOM-парсер" /> 
            <br/>
            ${errorLoginPassMessage}
            ${wrongAction}
            ${nullPage}
        </form>
        <form name = "val" action="gemstonesparsing" method="POST">
            <input type ="hidden" name="command" value="VAL" />
            <input type ="submit" name="button" value="Валидация XML-документа." /> 
            <br/>
            ${errorLoginPassMessage}
            ${wrongAction}
            ${nullPage}
        </form>
        <form name = "logout" action="gemstonesparsing" method="POST">
            <input type ="hidden" name="command" value="LOGOUT" />
            <input type ="submit" name="button" value="Выйти." /> 
            <br/>
            ${errorLoginPassMessage}
            ${wrongAction}
            ${nullPage}
        </form>
    </center>
    <c:import url="\common\footer.jspf" />

</body>
</html>
