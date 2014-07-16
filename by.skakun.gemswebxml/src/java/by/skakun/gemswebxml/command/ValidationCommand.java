
package by.skakun.gemswebxml.command;


import by.skakun.gemswebxml.xmlvalidating.ValidatingGem;
import javax.servlet.http.HttpServletRequest;


public class ValidationCommand implements ActionCommand {

    

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        ValidatingGem v = new ValidatingGem();
        String s1 = v.ValidatingNecklace();
        if(!s1.isEmpty()) {
            request.setAttribute("res", "Валидация xml-файла выполнена.<br/>" + s1);
            page = ConfigurationManager.getProperty("path.page.result");
        } else {
            request.setAttribute("errorLoginMessage", MessageManager.getProperty("message.loginerror"));
            page = ConfigurationManager.getProperty("path.page.login");
        }
        return page;

    }

}
