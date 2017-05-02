package com.heavenhr.web.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heavenhr.database.dao.ApplicationDAO;
import com.heavenhr.database.dao.OfferDAO;
import com.heavenhr.database.entity.ApplicationEntity;
import com.heavenhr.database.entity.OfferEntity;
import com.heavenhr.web.business.common.BeanMapper;
import com.heavenhr.web.business.dto.ApplicationInDTO;
import com.heavenhr.web.business.dto.ApplicationOutDTO;
import com.heavenhr.web.business.enums.ApplicationStatus;
import com.heavenhr.web.business.error.BadRequestException;
import com.heavenhr.web.business.error.ErrorCodes;
import com.heavenhr.web.business.error.ErrorMessage;
import com.heavenhr.web.business.error.NotFoundException;
import com.heavenhr.web.business.service.ApplicationService;

@Service
public class ApplicationServiceImpl implements ApplicationService
{
    @Autowired
    private OfferDAO offerDAO;

    @Autowired
    private ApplicationDAO applicationDAO;

    @Autowired
    private BeanMapper beanMapper;

    @Override
    public ApplicationOutDTO findOne(Integer offerId, Integer applicationId)
    {
        OfferEntity offerEntity = offerDAO.findOne(offerId);
        validateOfferExists(offerEntity);
        
        ApplicationEntity applicationEntity = applicationDAO.findOne(applicationId);
        validateApplicationExists(applicationEntity);
        
        return beanMapper.map(applicationEntity, ApplicationOutDTO.class);
    }

    @Override
    public List<ApplicationOutDTO> findAll(Integer offerId)
    {
        OfferEntity offerEntity = offerDAO.findOne(offerId);
        validateOfferExists(offerEntity);
        
        List<ApplicationEntity> applicationEntities = applicationDAO.findAll();
        
        return beanMapper.map(applicationEntities, ApplicationOutDTO.class);
    }

    @Override
    public ApplicationOutDTO save(Integer offerId, ApplicationInDTO applicationDTO)
    {
        OfferEntity offerEntity = offerDAO.findOne(offerId);
        validateOfferExists(offerEntity);
        
        validateEmailAlreadyRegisteredWithOffer(applicationDTO.getEmailId(), offerEntity);
        
        ApplicationEntity applicationEntity = beanMapper.map(applicationDTO, ApplicationEntity.class);
        applicationEntity.setStatus(ApplicationStatus.APPLIED.ordinal());
        applicationEntity.setOfferEntity(offerEntity);
        applicationEntity = applicationDAO.save(applicationEntity);
        
        offerEntity.setApplicationEntities(getApplicationEntities(offerEntity, applicationEntity));
        offerDAO.save(offerEntity);
        
        return beanMapper.map(applicationEntity, ApplicationOutDTO.class);
    }

    @Override
    public ApplicationOutDTO update(Integer offerId, Integer applicationId, ApplicationStatus applicationStatus)
    {
        OfferEntity offerEntity = offerDAO.findOne(offerId);
        validateOfferExists(offerEntity);
        ApplicationEntity applicationEntity = applicationDAO.findOne(applicationId);
        validateApplicationExists(applicationEntity);
        applicationEntity.setStatus(applicationStatus.ordinal());
        applicationEntity = applicationDAO.save(applicationEntity);
        return beanMapper.map(applicationEntity, ApplicationOutDTO.class);
    }
    
    private void validateOfferExists(OfferEntity offerEntity)
    {
        if (offerEntity == null)
        {
            throw new NotFoundException(new ErrorMessage(ErrorCodes.OFFER_DOES_NOT_EXISTS));
        }
    }
    
    private void validateApplicationExists(ApplicationEntity applicationEntity)
    {
        if (applicationEntity == null)
        {
            throw new NotFoundException(new ErrorMessage(ErrorCodes.APPLICATION_DOES_NOT_EXISTS));
        }
    }

    private void validateEmailAlreadyRegisteredWithOffer(String emailId, OfferEntity offerEntity)
    {
        for (ApplicationEntity applicationEntity : offerEntity.getApplicationEntities())
        {
            if (emailId.equals(applicationEntity.getEmailId()))
            {
                throw new BadRequestException(new ErrorMessage(ErrorCodes.EMAIL_ALREADY_REGISTERED_WITH_OFFER));
            }
        }
    }
    
    private List<ApplicationEntity> getApplicationEntities(OfferEntity offerEntity, ApplicationEntity applicationEntity)
    {
        List<ApplicationEntity> applicationEntities;
        if (offerEntity.getApplicationEntities() == null)
        {
            applicationEntities = new ArrayList<>();
        }
        else
        {
            applicationEntities = offerEntity.getApplicationEntities();
        }
        applicationEntities.add(applicationEntity);
        return applicationEntities;
    }
}
