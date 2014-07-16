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

/**
 *
 * @author apple
 */
public class ParseCommand implements ActionCommand {

    private String command;
    private final static String PATH_S = "src/java/resources/necklace.xml";
    private final static String PATH_D = "resources/necklace.xml";

    public ParseCommand(String command) {
        this.command = command;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        Set<Gem> s3 = null;
        NecklaceBuilderFactory nFactory = new NecklaceBuilderFactory();
        AbstractNecklaceBuilder builder = nFactory.createNecklaceBuilder(command.toLowerCase());
        if (command.toUpperCase().equals("DOM")) {
            s3 = builder.buildSetGems(PATH_D);
        } else {
            s3 = builder.buildSetGems(PATH_S);
        }
        if (!s3.isEmpty()) {
            request.setAttribute("res", (command.toUpperCase() + "-парсинг выполнен.<br/><hr/>")/* + ActionCommand.collectNecklace(s3)*/);
            page = ConfigurationManager.getProperty("path.page.result");
            request.setAttribute("lst", s3);
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
