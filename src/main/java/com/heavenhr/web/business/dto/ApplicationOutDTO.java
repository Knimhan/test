package com.heavenhr.web.business.dto;

import com.heavenhr.web.business.enums.ApplicationStatus;

import lombok.Data;

@Data
public class ApplicationOutDTO
{
    private Integer id;

    private String emailId;

    private String resumeText;

    private ApplicationStatus status;
}
