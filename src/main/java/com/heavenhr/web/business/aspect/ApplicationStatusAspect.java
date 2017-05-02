package com.heavenhr.web.business.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.heavenhr.web.business.enums.ApplicationStatus;
import com.heavenhr.web.business.service.ApplicationStatusService;

@Component
@Aspect
public class ApplicationStatusAspect
{

    @Autowired
    private ApplicationStatusService applicationStatusService;

    @After("execution (* com.heavenhr.web.business.service.impl.ApplicationServiceImpl.update(..))")
    public void logAfter(JoinPoint joinPoint)
    {
        Object[] signatureArgs = joinPoint.getArgs();
        applicationStatusService.afterStatusChange((Integer) signatureArgs[1], (ApplicationStatus) signatureArgs[2]);
    }
}
