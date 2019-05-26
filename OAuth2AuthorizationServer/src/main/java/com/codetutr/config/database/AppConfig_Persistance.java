package com.codetutr.config.database;

import javax.transaction.TransactionManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@EnableAspectJAutoProxy(proxyTargetClass = true)
@Import(value={DatasourceConfig.class, SpringJPAConfig.class})
public class AppConfig_Persistance {

	private LocalContainerEntityManagerFactoryBean entityManagerFactoryBean;
	
	@Autowired
	private AppConfig_Persistance(LocalContainerEntityManagerFactoryBean entityManagerFactoryBean){
		this.entityManagerFactoryBean = entityManagerFactoryBean;
	}
	
	/**
	 * This {@link TransactionManager} is for {@link SpringJPA} and {@link SpringData}. Since the {@link SpringData} has internally used a bean name as {@link transactionManager}, 
	 * we cannot rename it.Otherwise it will give an exception.
	 */
	@Bean(name="transactionManager")
	public PlatformTransactionManager getSpringJpaTransactionManager() {
		final JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactoryBean.getObject());
		return transactionManager; 
	}
}
