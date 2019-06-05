package com.codetutr.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(transactionManager = "transactionManager", propagation = Propagation.REQUIRED)
public class SpringEmJPADaoImpl {

	@PersistenceContext
	private EntityManager entityManager;

	public String test() {
		Query createNamedQuery = entityManager.createNativeQuery("SELECT * FROM oauth_client_details");
		Integer size = createNamedQuery.getResultList().size();

		return size + " is the rows i found in this table";
	}
}
