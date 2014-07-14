
package by.skakun.gemswebxml.command;

import by.skakun.gemswebxml.entity.Gem;
import by.skakun.gemswebxml.xmlparsers.AbstractNecklaceBuilder;
import by.skakun.gemswebxml.xmlparsers.NecklaceBuilderFactory;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;


public class STAXCommand implements ActionCommand {
    private final static String PATH = "src/java/resources/necklace.xml";
    
    private STAXCommand c;

    @Override
    public String execute(HttpServletRequest request) {
        Set <Gem> s3;
        String page = null;
        NecklaceBuilderFactory nFactory = new NecklaceBuilderFactory();
        AbstractNecklaceBuilder builder = nFactory.createNecklaceBuilder("stax");
        s3 = builder.buildSetGems(PATH);
        
        if(!s3.isEmpty()) {
            request.setAttribute("res", "STAX-парсинг выполнен.<br/>" + ActionCommand.collectNecklace(s3));
            page = ConfigurationManager.getProperty("path.page.result");
        } else {
            request.setAttribute("errorLoginMessage", MessageManager.getProperty("message.loginerror"));
            page = ConfigurationManager.getProperty("path.page.login");
        }
        return page;

    }
   

}
