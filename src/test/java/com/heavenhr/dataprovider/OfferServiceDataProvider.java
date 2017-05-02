package com.heavenhr.dataprovider;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.heavenhr.database.entity.ApplicationEntity;
import com.heavenhr.database.entity.OfferEntity;
import com.heavenhr.web.business.dto.ApplicationInDTO;
import com.heavenhr.web.business.dto.OfferInDTO;

public class OfferServiceDataProvider
{
    private OfferServiceDataProvider()
    {
        throw new AssertionError();
    }

    @DataProvider
    public static Object[][] getDataForFindOneOfferWhereOfferIdIsInvalid()
    {
        Integer id = 101;
        OfferEntity offerEntity = null;
        return new Object[][] { { id, offerEntity } };
    }

    @DataProvider
    public static Object[][] getDataForFindAll()
    {
        Integer id = 101;

        ApplicationInDTO applicationDTO = new ApplicationInDTO();
        applicationDTO.setEmailId("candidate@gmail.com");

        ApplicationEntity applicationEntity = new ApplicationEntity();
        applicationEntity.setEmailId("candidate@gmail.com");
        List<ApplicationEntity> applicationEntities = new ArrayList<>();
        applicationEntities.add(applicationEntity);

        OfferEntity offerEntity = new OfferEntity();
        offerEntity.setId(101);
        offerEntity.setTitle("Java Developer");
        offerEntity.setApplicationEntities(applicationEntities);

        return new Object[][] { { id, applicationDTO, offerEntity } };
    }

    @DataProvider
    public static Object[][] getDataForSaveOfferWhereOfferTitleIsInvalid()
    {
        String title = "Java Developer";

        OfferInDTO offerDTO = new OfferInDTO();
        offerDTO.setStartDate(LocalDate.now());
        offerDTO.setTitle("Java Developer");

        OfferEntity offerEntity = new OfferEntity();
        offerEntity.setTitle("Java Developer");

        return new Object[][] { { title, offerDTO, offerEntity } };
    }

    @DataProvider
    public static Object[][] getDataForSaveApplicationWhereCandidateEmailIsAlreadyRegistered()
    {

        Integer id = 101;

        ApplicationInDTO applicationDTO = new ApplicationInDTO();
        applicationDTO.setEmailId("candidate@gmail.com");

        ApplicationEntity applicationEntity = new ApplicationEntity();
        applicationEntity.setEmailId("candidate@gmail.com");
        List<ApplicationEntity> applicationEntities = new ArrayList<>();
        applicationEntities.add(applicationEntity);

        OfferEntity offerEntity = new OfferEntity();
        offerEntity.setId(101);
        offerEntity.setTitle("Java Developer");
        offerEntity.setApplicationEntities(applicationEntities);

        return new Object[][] { { id, applicationDTO, offerEntity } };
    }
}
