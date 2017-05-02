package com.heavenhr.web.business.error;

public class BadRequestException extends AbstractException {
    private static final long serialVersionUID = 1L;

    public BadRequestException(ErrorMessage errorMessage) {
        super(errorMessage);
    }
}
