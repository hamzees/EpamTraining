package by.skakun.gemswebxml.command;

import javax.servlet.http.HttpServletRequest;


public class LoginCommand implements ActionCommand {

    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String password = request.getParameter(PARAM_NAME_PASSWORD);
        if (LoginLogic.checkLogin(login, password)) {
            request.setAttribute("user", login);
            page = ConfigurationManager.getProperty("path.page.main");
        } else {
            request.setAttribute("errorLoginMessage",("<h4>" + MessageManager.getProperty("message.loginerror") + "</h4>"));
            page = ConfigurationManager.getProperty("path.page.login");
        }
        return page;
    }

}
