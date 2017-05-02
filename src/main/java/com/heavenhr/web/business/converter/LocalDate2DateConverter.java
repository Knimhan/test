package com.heavenhr.web.business.converter;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.dozer.DozerConverter;

public class LocalDate2DateConverter extends DozerConverter<LocalDate, Date>
{
    public LocalDate2DateConverter()
    {
        super(LocalDate.class, Date.class);
    }

    @Override
    public Date convertTo(LocalDate source, Date destination)
    {
        return source == null ? null : Date.from(source.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    @Override
    public LocalDate convertFrom(Date source, LocalDate destination)
    {
        return source == null ? null : source.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
}
