package com.heavenhr.web.business.service;

import com.heavenhr.web.business.enums.ApplicationStatus;

public interface ApplicationStatusService
{
    public void afterStatusChange(Integer applicationId, ApplicationStatus applicationStatus);
}
