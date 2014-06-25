package by.skakun.gemstones.exception;

/**
 *
 * @author skakun
 */
public class NecklaceLogicException extends Exception {

    public NecklaceLogicException() {
    }

    public NecklaceLogicException(String msg) {
        super(msg);
    }

    public NecklaceLogicException(String message, Throwable cause) {
        super(message, cause);
    }

    public NecklaceLogicException(Throwable cause) {
        super(cause);
    }
    protected NecklaceLogicException(String msg, Throwable cause, boolean 
            enableSuppression, boolean writableStackTrace){
        super(msg,cause,enableSuppression,writableStackTrace);
    }
}
