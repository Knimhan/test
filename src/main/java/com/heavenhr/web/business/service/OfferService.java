package com.heavenhr.web.business.service;

import java.util.List;

import com.heavenhr.web.business.dto.OfferInDTO;
import com.heavenhr.web.business.dto.OfferOutDTO;

public interface OfferService
{
    public OfferOutDTO findOne(Integer id);

    public List<OfferOutDTO> findAll();

    public OfferOutDTO save(OfferInDTO offerDTO);
}
