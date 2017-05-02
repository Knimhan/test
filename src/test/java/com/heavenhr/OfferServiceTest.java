package com.heavenhr;

import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.heavenhr.database.dao.OfferDAO;
import com.heavenhr.database.entity.OfferEntity;
import com.heavenhr.dataprovider.OfferServiceDataProvider;
import com.heavenhr.web.business.dto.OfferInDTO;
import com.heavenhr.web.business.error.BadRequestException;
import com.heavenhr.web.business.error.ErrorCodes;
import com.heavenhr.web.business.error.NotFoundException;
import com.heavenhr.web.business.service.OfferService;
import com.heavenhr.web.business.service.impl.OfferServiceImpl;

public class OfferServiceTest
{
    @Mock
    private OfferDAO offerDAO;

    @InjectMocks
    private OfferService offerService;

    @BeforeMethod
    public void initMock()
    {
        offerService = new OfferServiceImpl();
        MockitoAnnotations.initMocks(this);
    }

    @Test(dataProvider = "getDataWhereOfferIdIsInvalid", dataProviderClass = OfferServiceDataProvider.class)
    public void shouldThrowNotFoundExceptiobForInvalidOfferIdWhileFindOneOffer(Integer id, OfferEntity offerEntity)
    {
        when(offerDAO.findOne(id)).thenReturn(offerEntity);
        try
        {
            offerService.findOne(id);
            Assert.fail("Expected exception to be thrown");
        }
        catch (NotFoundException exception)
        {
            assertEquals(exception.getErrorMessage().getCode(), ErrorCodes.OFFER_DOES_NOT_EXISTS.getCode());
        }
    }

    @Test(dataProvider = "getDataWhereOfferTitleIsInvalid", dataProviderClass = OfferServiceDataProvider.class)
    public void shouldThrowBREForInvalidOfferTitleWhileSaveOffer(String title, OfferInDTO offerDTO, OfferEntity offerEntity)
    {
        when(offerDAO.findByTitle(title)).thenReturn(offerEntity);
        try
        {
            offerService.save(offerDTO);
            Assert.fail("Expected exception to be thrown");
        }
        catch (BadRequestException exception)
        {
            assertEquals(exception.getErrorMessage().getCode(), ErrorCodes.OFFER_TITLE_ALREADY_REGISTERED.getCode());
        }
    }
}
