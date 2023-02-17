package org.BEDU.proyecto.exception;


public class ResourceNotFoundException extends Exception {
    private int errorCode;
    public ResourceNotFoundException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
    public int getErrorCode() {
        return errorCode;
    }
}
