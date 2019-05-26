package com.codetutr.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.codetutr.entity.Country;

@Repository
@Transactional(transactionManager = "transactionManager", propagation = Propagation.REQUIRED)
public class SpringEmJPADaoImpl {

    @PersistenceContext
    private EntityManager entityManager;
    
	public List<Country> getUserByName(String name) {
		return entityManager.createQuery("SELECT c FROM Country c", Country.class).getResultList();
	}
}
