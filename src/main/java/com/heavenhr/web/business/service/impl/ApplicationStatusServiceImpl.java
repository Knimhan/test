package com.heavenhr.web.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heavenhr.database.dao.ApplicationDAO;
import com.heavenhr.database.entity.ApplicationEntity;
import com.heavenhr.web.business.enums.ApplicationStatus;
import com.heavenhr.web.business.error.ErrorCodes;
import com.heavenhr.web.business.error.ErrorMessage;
import com.heavenhr.web.business.error.NotFoundException;
import com.heavenhr.web.business.service.ApplicationStatusService;
import com.heavenhr.web.business.service.NotificationService;

@Service
public class ApplicationStatusServiceImpl implements ApplicationStatusService
{

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private ApplicationDAO applicationDAO;

    @Override
    public void afterStatusChange(Integer applicationId, ApplicationStatus applicationStatus)
    {
        ApplicationEntity applicationEntity = findOne(applicationId);
        String message = null;

        switch (applicationStatus)
        {
            case APPLIED:
                message = applicationEntity.getEmailId() + " has applied for " + applicationEntity.getOfferEntity().getTitle();
                break;
            case INVITED:
                message = applicationEntity.getEmailId() + " has been invited for interview";
                break;
            case REJECTED:
                message = "Sorry! " + applicationEntity.getEmailId() + " has been rejected";
                break;
            case HIRED:
                message = "Congratulations! " + applicationEntity.getEmailId() + " has been hired";
                break;
        }

        notificationService.send(message);
    }

    private ApplicationEntity findOne(Integer id)
    {
        ApplicationEntity applicationEntity = applicationDAO.findOne(id);
        if (applicationEntity == null)
        {
            throw new NotFoundException(new ErrorMessage(ErrorCodes.APPLICATION_DOES_NOT_EXISTS));
        }
        return applicationEntity;
    }

}
