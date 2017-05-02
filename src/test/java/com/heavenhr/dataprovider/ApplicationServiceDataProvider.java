package com.heavenhr.dataprovider;

import org.testng.annotations.DataProvider;

import com.heavenhr.database.entity.ApplicationEntity;

public class ApplicationServiceDataProvider
{
    private ApplicationServiceDataProvider()
    {
        throw new AssertionError();
    }

    @DataProvider
    public static Object[][] getDataForFindOneApplicationWhereApplicationIdIsInvalid()
    {
        Integer id = 101;
        ApplicationEntity applicationEntity = null;
        return new Object[][] { { id, applicationEntity } };
    }
}
