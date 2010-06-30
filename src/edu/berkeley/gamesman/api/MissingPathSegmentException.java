package edu.berkeley.gamesman.api;

public class MissingPathSegmentException extends RuntimeException {
    
    private static final long serialVersionUID = -8876585336649506128L;

    public MissingPathSegmentException() { }
    
    public MissingPathSegmentException(String message) {
        super(message);
    }

    public MissingPathSegmentException(Throwable cause) {
        super(cause);
    }

    public MissingPathSegmentException(String message, Throwable cause) {
        super(message, cause);
    }
}
