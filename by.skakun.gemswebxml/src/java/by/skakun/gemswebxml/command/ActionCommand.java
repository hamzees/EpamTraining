package by.skakun.gemswebxml.command;

import by.skakun.gemswebxml.entity.Gem;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;


public interface ActionCommand {
    String execute (HttpServletRequest request);
    static String collectNecklace(Set <Gem> s3) {
        StringBuilder gems = new StringBuilder();
        s3.stream().forEach((emp) -> {
            gems.append(emp).append("<br/><hr/>");
        });
        return gems.toString();
    }
}
