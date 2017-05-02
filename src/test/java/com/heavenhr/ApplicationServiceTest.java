package com.heavenhr;

import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.heavenhr.database.dao.ApplicationDAO;
import com.heavenhr.database.dao.OfferDAO;
import com.heavenhr.database.entity.ApplicationEntity;
import com.heavenhr.database.entity.OfferEntity;
import com.heavenhr.dataprovider.ApplicationServiceDataProvider;
import com.heavenhr.web.business.dto.ApplicationInDTO;
import com.heavenhr.web.business.enums.ApplicationStatus;
import com.heavenhr.web.business.error.BadRequestException;
import com.heavenhr.web.business.error.ErrorCodes;
import com.heavenhr.web.business.error.NotFoundException;
import com.heavenhr.web.business.service.ApplicationService;
import com.heavenhr.web.business.service.OfferService;
import com.heavenhr.web.business.service.impl.ApplicationServiceImpl;
import com.heavenhr.web.business.service.impl.OfferServiceImpl;

public class ApplicationServiceTest
{

    @Mock
    private OfferDAO offerDAO;

    @Mock
    private ApplicationDAO applicationDAO;

    @InjectMocks
    private OfferService offerService;

    @InjectMocks
    private ApplicationService applicationService;

    @BeforeMethod
    public void initMock()
    {
        offerService = new OfferServiceImpl();
        applicationService = new ApplicationServiceImpl();
        MockitoAnnotations.initMocks(this);
    }

    @Test(dataProvider = "getDataWhereOfferIdIsInvalid", dataProviderClass = ApplicationServiceDataProvider.class)
    public void shouldThrowNotFoundExceptionForInvalidOfferIdWhileFindOneApplication(Integer offerId, OfferEntity offerEntity)
    {
        when(offerDAO.findOne(offerId)).thenReturn(offerEntity);
        try
        {
            applicationService.findOne(offerId, 101);
            Assert.fail("Expected exception to be thrown");
        }
        catch (NotFoundException exception)
        {
            assertEquals(exception.getErrorMessage().getCode(), ErrorCodes.OFFER_DOES_NOT_EXISTS.getCode());
        }
    }

    @Test(dataProvider = "getDataWhereApplicationIdIsInvalid", dataProviderClass = ApplicationServiceDataProvider.class)
    public void shouldThrowNotFoundExceptionForInvalidApplicationIdWhileFindOneApplication(OfferEntity offerEntity, Integer applicationId, ApplicationEntity applicationEntity)
    {
        when(offerDAO.findOne(offerEntity.getId())).thenReturn(offerEntity);
        when(applicationDAO.findOne(applicationId)).thenReturn(applicationEntity);
        try
        {
            applicationService.findOne(offerEntity.getId(), applicationId);
            Assert.fail("Expected exception to be thrown");
        }
        catch (NotFoundException exception)
        {
            assertEquals(exception.getErrorMessage().getCode(), ErrorCodes.APPLICATION_DOES_NOT_EXISTS.getCode());
        }
    }

    @Test(dataProvider = "getDataWhereOfferIdIsInvalid", dataProviderClass = ApplicationServiceDataProvider.class)
    public void shouldThrowNotFoundExceptionForInvalidOfferIdWhileFindAllApplications(Integer offerId, OfferEntity offerEntity)
    {
        when(offerDAO.findOne(offerId)).thenReturn(offerEntity);
        try
        {
            applicationService.findAll(offerId);
            Assert.fail("Expected exception to be thrown");
        }
        catch (NotFoundException exception)
        {
            assertEquals(exception.getErrorMessage().getCode(), ErrorCodes.OFFER_DOES_NOT_EXISTS.getCode());
        }
    }

    @Test(dataProvider = "getDataWhereOfferIdIsInvalid", dataProviderClass = ApplicationServiceDataProvider.class)
    public void shouldThrowNotFoundExceptionForInvalidOfferIdWhileSaveApplication(Integer offerId, OfferEntity offerEntity)
    {
        when(offerDAO.findOne(offerId)).thenReturn(offerEntity);
        try
        {
            applicationService.save(offerId, new ApplicationInDTO());
            Assert.fail("Expected exception to be thrown");
        }
        catch (NotFoundException exception)
        {
            assertEquals(exception.getErrorMessage().getCode(), ErrorCodes.OFFER_DOES_NOT_EXISTS.getCode());
        }
    }

    @Test(dataProvider = "getDataWhereEmailIdIsInvalid", dataProviderClass = ApplicationServiceDataProvider.class)
    public void shouldThrowBadRequestExceptionForInvalidEmailIdWhileSaveApplication(OfferEntity offerEntity, ApplicationInDTO applicationInDTO)
    {
        when(offerDAO.findOne(offerEntity.getId())).thenReturn(offerEntity);
        try
        {
            applicationService.save(offerEntity.getId(), applicationInDTO);
            Assert.fail("Expected exception to be thrown");
        }
        catch (BadRequestException exception)
        {
            assertEquals(exception.getErrorMessage().getCode(), ErrorCodes.EMAIL_ALREADY_REGISTERED_WITH_OFFER.getCode());
        }
    }
    
    @Test(dataProvider = "getDataWhereOfferIdIsInvalid", dataProviderClass = ApplicationServiceDataProvider.class)
    public void shouldThrowNotFoundExceptionForInvalidOfferIdWhileUpdateApplicationStatus(Integer offerId, OfferEntity offerEntity)
    {
        when(offerDAO.findOne(offerId)).thenReturn(offerEntity);
        try
        {
            applicationService.update(offerId, 1, ApplicationStatus.INVITED);
            Assert.fail("Expected exception to be thrown");
        }
        catch (NotFoundException exception)
        {
            assertEquals(exception.getErrorMessage().getCode(), ErrorCodes.OFFER_DOES_NOT_EXISTS.getCode());
        }
    }
}
