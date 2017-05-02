package com.heavenhr.web.business.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.heavenhr.web.business.service.NotificationService;

@Service
public class NotificationServiceImpl implements NotificationService
{

    private static final Logger log = LoggerFactory.getLogger(NotificationServiceImpl.class);

    @Override
    public void send(String message)
    {
        log.info(message);
    }

}
