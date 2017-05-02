package com.heavenhr.web.business.enums;

public enum ApplicationStatus
{
    APPLIED("Applied"),
    INVITED("Invited"),
    REJECTED("Rejected"),
    HIRED("Hired");

    private String string;

    private ApplicationStatus(String string)
    {
        this.string = string;
    }

    public String getString()
    {
        return string;
    }

}
