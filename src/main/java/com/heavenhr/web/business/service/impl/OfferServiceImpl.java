package com.heavenhr.web.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heavenhr.database.dao.OfferDAO;
import com.heavenhr.database.entity.OfferEntity;
import com.heavenhr.web.business.common.BeanMapper;
import com.heavenhr.web.business.dto.OfferInDTO;
import com.heavenhr.web.business.dto.OfferOutDTO;
import com.heavenhr.web.business.error.BadRequestException;
import com.heavenhr.web.business.error.ErrorCodes;
import com.heavenhr.web.business.error.ErrorMessage;
import com.heavenhr.web.business.error.NotFoundException;
import com.heavenhr.web.business.service.OfferService;

@Service
public class OfferServiceImpl implements OfferService
{

    @Autowired
    private OfferDAO offerDAO;

    @Autowired
    private BeanMapper beanMapper;

    @Override
    public OfferOutDTO findOne(Integer id)
    {
        OfferEntity offerEntity = offerDAO.findOne(id);
        validateOfferExists(offerEntity);
        return beanMapper.map(offerEntity, OfferOutDTO.class);
    }

    @Override
    public List<OfferOutDTO> findAll()
    {
        List<OfferEntity> offerEntities = offerDAO.findAll();
        return beanMapper.map(offerEntities, OfferOutDTO.class);
    }

    @Override
    public OfferOutDTO save(OfferInDTO offerDTO)
    {
        validateOfferTitle(offerDTO.getTitle());
        OfferEntity offerEntity = beanMapper.map(offerDTO, OfferEntity.class);
        offerEntity = offerDAO.save(offerEntity);
        return beanMapper.map(offerEntity, OfferOutDTO.class);
    }

    private void validateOfferTitle(String title)
    {
        if (offerDAO.findByTitle(title) != null)
        {
            throw new BadRequestException(new ErrorMessage(ErrorCodes.OFFER_TITLE_ALREADY_REGISTERED));
        }
    }

    private void validateOfferExists(OfferEntity offerEntity)
    {
        if (offerEntity == null)
        {
            throw new NotFoundException(new ErrorMessage(ErrorCodes.OFFER_DOES_NOT_EXISTS));
        }
    }
}
