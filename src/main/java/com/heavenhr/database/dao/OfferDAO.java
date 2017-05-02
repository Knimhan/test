package com.heavenhr.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.heavenhr.database.entity.OfferEntity;

public interface OfferDAO extends JpaRepository<OfferEntity, Integer>
{
    OfferEntity findByTitle(String title);
}