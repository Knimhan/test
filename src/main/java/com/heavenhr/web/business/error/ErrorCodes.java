package com.heavenhr.web.business.error;

public enum ErrorCodes
{
    // returned on valueOf with illegal error code
    VALUE_OF_UNKNOWN(1, "unknown error code provided for valueOf(int)"),

    // general error codes and messages
    VALIDATION_ERROR(1000, "Data validation errors"),
    SERVER_ERROR(1001, "Server error"),

    // offer
    OFFER_DOES_NOT_EXISTS(2000, "Offer dose not exists"),
    OFFER_TITLE_ALREADY_REGISTERED(2001, "Offer title already registered"),

    //application
    APPLICATION_DOES_NOT_EXISTS(3000,"Application does not exists"),
    EMAIL_ALREADY_REGISTERED_WITH_OFFER(2001, "Email already registered for this offer");

    private int code;
    private String message;

    private ErrorCodes(int code, String message)
    {
        this.code = code;
        this.message = message;
    }

    public int getCode()
    {
        return code;
    }

    public String getMessage()
    {
        return message;
    }

    public static ErrorCodes valueOf(int code)
    {
        ErrorCodes returnedErrorCode = null;

        for (ErrorCodes errorCode : ErrorCodes.values())
        {
            if (errorCode.getCode() == code)
            {
                returnedErrorCode = errorCode;
                break;
            }
        }

        // no ErrorCode found for given code
        if (returnedErrorCode == null)
        {
            returnedErrorCode = ErrorCodes.VALUE_OF_UNKNOWN;
        }

        return returnedErrorCode;
    }

}
