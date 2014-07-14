package by.skakun.gemswebxml.command;

import javax.servlet.http.HttpServletRequest;

public class ActionFactory {
    public ActionCommand defineCommand(HttpServletRequest request){
       ActionCommand current = new EmptyCommand();
       String action = request.getParameter("command");
       if(action == null || action.isEmpty()){
           return current;
       }
       try {
           CommandEnum currentEnum =CommandEnum.valueOf(action.toUpperCase());
           current = currentEnum.getCurrentCommand();
       } catch (IllegalArgumentException ex) {
          request.setAttribute("wrongcAtion", action + MessageManager.getProperty("message.wrongaction"));
       }
       return current;
    }
    
}
