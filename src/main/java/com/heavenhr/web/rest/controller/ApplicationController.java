package com.heavenhr.web.rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.heavenhr.web.business.dto.ApplicationInDTO;
import com.heavenhr.web.business.dto.ApplicationOutDTO;
import com.heavenhr.web.business.enums.ApplicationStatus;
import com.heavenhr.web.business.service.ApplicationService;

import io.swagger.annotations.Api;

@Api(tags = "application")
@RestController
@RequestMapping(value = "/api/offers/{offerId}/applications")
public class ApplicationController
{
    @Autowired
    private ApplicationService applicationService;

    @GetMapping("/{applicationId}")
    public ApplicationOutDTO findOne(@PathVariable Integer offerId, @PathVariable Integer applicationId)
    {
        return applicationService.findOne(offerId, applicationId);
    }

    @GetMapping
    public List<ApplicationOutDTO> findAll(@PathVariable Integer offerId)
    {
        return applicationService.findAll(offerId);
    }

    @PostMapping
    public ApplicationOutDTO save(@PathVariable Integer offerId, @Valid @RequestBody(required = true) ApplicationInDTO applicationDTO)
    {
        return applicationService.save(offerId, applicationDTO);
    }

    @PutMapping("/{applicationId}")
    public ApplicationOutDTO update(@PathVariable Integer offerId, @PathVariable Integer applicationId, @RequestParam("status") ApplicationStatus applicationStatus)
    {
        return applicationService.update(offerId, applicationId, applicationStatus);
    }
}
