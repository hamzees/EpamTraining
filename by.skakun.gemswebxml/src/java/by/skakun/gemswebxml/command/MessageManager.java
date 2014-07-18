package by.skakun.gemswebxml.command;

import java.util.ResourceBundle;

public class MessageManager {
    private final static ResourceBundle resourceBundle = 
                         ResourceBundle.getBundle("properties.message");
    private MessageManager(){};
    
    public static String getProperty(String key){
        return resourceBundle.getString(key);
    } 
    
}
