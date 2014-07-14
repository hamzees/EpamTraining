<%-- 
    Document   : main
    Created on : 13.07.2014, 19:45:37
    Author     : apple
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Задание 3 - XML-парсеры</title>
    </head>
    <body>
        <h5>Здравствуйте, ${user} </h5>
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



    </body>
</html>
