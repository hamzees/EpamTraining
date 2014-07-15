package by.skakun.tunnel.exception;

public class TrainException extends Exception {

    public TrainException() {
    }

    public TrainException(String msg) {
        super(msg);
    }

    public TrainException(String message, Throwable cause) {
        super(message, cause);
    }

    public TrainException(Throwable cause) {
        super(cause);
    }
    protected TrainException(String msg, Throwable cause, boolean 
            enableSuppression, boolean writableStackTrace){
        super(msg,cause,enableSuppression,writableStackTrace);
    }
}
