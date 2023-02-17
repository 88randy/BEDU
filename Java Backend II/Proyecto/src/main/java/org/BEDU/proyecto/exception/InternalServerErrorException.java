package org.BEDU.proyecto.exception;

public class InternalServerErrorException extends Exception {
    private int errorCode;
    public InternalServerErrorException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
    public int getErrorCode() {
        return errorCode;
    }
}
