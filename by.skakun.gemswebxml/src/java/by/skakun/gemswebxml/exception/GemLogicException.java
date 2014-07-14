package by.skakun.gemswebxml.exception;

/**
 *
 * @author skakun
 */
public class GemLogicException extends Exception {

    public GemLogicException() {
    }

    public GemLogicException(String msg) {
        super(msg);
    }

    public GemLogicException(String message, Throwable cause) {
        super(message, cause);
    }

    public GemLogicException(Throwable cause) {
        super(cause);
    }
    protected GemLogicException(String msg, Throwable cause, boolean 
            enableSuppression, boolean writableStackTrace){
        super(msg,cause,enableSuppression,writableStackTrace);
    }
}
