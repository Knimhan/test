package com.heavenhr.web.business.error;

public class NotFoundException extends AbstractException {
    private static final long serialVersionUID = 1L;

    public NotFoundException(ErrorMessage errorMessage) {
        super(errorMessage);
    }
}
