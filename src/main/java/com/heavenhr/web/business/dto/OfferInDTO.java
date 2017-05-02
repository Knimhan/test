package com.heavenhr.web.business.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Data
public class OfferInDTO
{
    @NotEmpty
    private String title;

    @NotNull
    private LocalDate startDate;

}
