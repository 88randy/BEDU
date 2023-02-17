package org.BEDU.proyecto.exception;

public class OperationNotAllowedException extends Exception {
    private int errorCode;
    public OperationNotAllowedException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
    public int getErrorCode() {
        return errorCode;
    }
}
