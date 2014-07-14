package by.skakun.gemswebxml.command;


public class LoginLogic {
    private final static String ROOT_LOGIN = "root";
    private final static String ROOT_PASS = "1234";
    public static boolean checkLogin(String enterLogin, String enterPassword){
       return ROOT_LOGIN.equals(enterLogin) && ROOT_PASS.equals(enterPassword);
    }
    
}
