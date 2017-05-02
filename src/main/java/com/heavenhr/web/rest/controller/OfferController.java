package com.heavenhr.web.rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.heavenhr.web.business.dto.OfferInDTO;
import com.heavenhr.web.business.dto.OfferOutDTO;
import com.heavenhr.web.business.service.OfferService;

import io.swagger.annotations.Api;

@Api(tags = "offer")
@RestController
@RequestMapping(value = "/api/offers")
public class OfferController
{
    @Autowired
    private OfferService offerService;

    @GetMapping("/{id}")
    public OfferOutDTO findOne(@PathVariable Integer id)
    {
        return offerService.findOne(id);
    }

    @GetMapping
    public List<OfferOutDTO> findAll()
    {
        return offerService.findAll();
    }

    @PostMapping
    public OfferOutDTO save(@Valid @RequestBody(required = true) OfferInDTO offerInDTO)
    {
        return offerService.save(offerInDTO);
    }
}
