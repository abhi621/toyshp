package com.example.toyshop.exception;

public class ToyShopCustomException extends Exception {

    private static final long serialVersionUID = 1L;

//    private static final Logger logger = LogManager.getLogger(ToyshopApplication.class)

    private final String message;
    private final String errorCode;

    public ToyShopCustomException(String message) {
        super(message);
        this.message = message;
        this.errorCode = null;
    }

    public ToyShopCustomException(String message, String errorCode) {
        super(message);
        this.message = message;
        this.errorCode = errorCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public String getErrorCode() {
        return errorCode;
    }


}
