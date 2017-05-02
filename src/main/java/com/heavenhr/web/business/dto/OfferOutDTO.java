package com.heavenhr.web.business.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class OfferOutDTO
{
    private Integer id;

    private String title;

    private LocalDate startDate;
}
