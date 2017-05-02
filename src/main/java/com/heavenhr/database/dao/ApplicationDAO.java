package com.heavenhr.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.heavenhr.database.entity.ApplicationEntity;

public interface ApplicationDAO extends JpaRepository<ApplicationEntity, Integer>
{

}