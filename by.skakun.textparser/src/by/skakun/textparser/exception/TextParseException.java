package by.skakun.textparser.exception;

public class TextParseException extends TextException {


	public TextParseException() {
	}

	public TextParseException(String message) {
		super(message);
	}

	public TextParseException(Throwable cause) {
		super(cause);
	}

	public TextParseException(String message, Throwable cause) {
		super(message, cause);
	}

	public TextParseException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
