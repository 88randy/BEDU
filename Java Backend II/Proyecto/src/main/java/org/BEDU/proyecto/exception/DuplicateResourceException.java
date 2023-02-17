package org.BEDU.proyecto.exception;

public class DuplicateResourceException extends Exception {
    private int errorCode;
    public DuplicateResourceException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
    public int getErrorCode() {
        return errorCode;
    }
}
