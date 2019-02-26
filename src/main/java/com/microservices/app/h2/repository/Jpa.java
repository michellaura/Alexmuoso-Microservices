package com.microservices.app.h2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.microservices.app.h2.model.daos.H2ClientDao;

@Component
public interface Jpa extends JpaRepository<H2ClientDao, Long> {

}
