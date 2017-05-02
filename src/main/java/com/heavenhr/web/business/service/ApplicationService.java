package com.heavenhr.web.business.service;

import java.util.List;

import com.heavenhr.web.business.dto.ApplicationInDTO;
import com.heavenhr.web.business.dto.ApplicationOutDTO;
import com.heavenhr.web.business.enums.ApplicationStatus;

public interface ApplicationService
{
    public ApplicationOutDTO findOne(Integer offerId, Integer applicationId);

    public List<ApplicationOutDTO> findAll(Integer offerId);

    public ApplicationOutDTO save(Integer offerId, ApplicationInDTO applicationDTO);

    public ApplicationOutDTO update(Integer offerId, Integer applicationId, ApplicationStatus applicationStatus);
}
