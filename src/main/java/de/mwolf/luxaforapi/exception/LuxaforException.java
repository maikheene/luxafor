package de.mwolf.luxaforapi.exception;

public class LuxaforException extends Exception {

    public LuxaforException() {
        super();
    }

    public LuxaforException(String message) {
        super(message);
    }

    public LuxaforException(String message, Throwable cause) {
        super(message, cause);
    }

    public LuxaforException(Throwable cause) {
        super(cause);
    }
}
