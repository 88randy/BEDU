package org.BEDU.proyecto.exception;

public class InvalidRequestException extends Exception {
    private int errorCode;
    public InvalidRequestException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
    public int getErrorCode() {
        return errorCode;
    }
}