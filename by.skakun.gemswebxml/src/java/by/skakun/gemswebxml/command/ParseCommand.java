/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.skakun.gemswebxml.command;

import by.skakun.gemswebxml.entity.Gem;
import by.skakun.gemswebxml.xmlparsers.AbstractNecklaceBuilder;
import by.skakun.gemswebxml.xmlparsers.NecklaceBuilderFactory;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;

public class ParseCommand implements ActionCommand {

    private String command;
    private final static String PATH_S = "src/java/resources/necklace.xml";
    private final static String PATH_D = "resources/necklace.xml";

    public ParseCommand(String command) {
        this.command = command;
    }

     /**
     *
     * @param request
     * @return content for page result/or redirects to login page with error message
     */
    @Override
    public String execute(HttpServletRequest request) {
        String page;
        Set<Gem> gemset;
        NecklaceBuilderFactory nFactory = new NecklaceBuilderFactory();
        AbstractNecklaceBuilder builder = nFactory.createNecklaceBuilder(command.toLowerCase());
        if (command.toUpperCase().equals("DOM")) {
            gemset = builder.buildSetGems(PATH_D);
        } else {
            gemset = builder.buildSetGems(PATH_S);
        }
        if (!gemset.isEmpty()) {
            request.setAttribute("res", (command.toUpperCase() + "-парсинг выполнен.<br/><hr/>")/* + ActionCommand.collectNecklace(gemset)*/);
            page = ConfigurationManager.getProperty("path.page.result");
            request.setAttribute("lst", gemset);
            request.setAttribute("tablebegin", "<tr>\n"
                    + "<th>Информация об ожерелье:</th>\n"
                    + "</tr>");

        } else {
            request.setAttribute("errorLoginMessage", MessageManager.getProperty("message.loginerror"));
            page = ConfigurationManager.getProperty("path.page.login");
        }
        return page;

    }

}
