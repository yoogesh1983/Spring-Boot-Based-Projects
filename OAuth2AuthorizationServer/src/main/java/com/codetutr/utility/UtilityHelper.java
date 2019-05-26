package com.codetutr.utility;

import java.util.Properties;

public class UtilityHelper {

	private UtilityHelper() {
		super();
	}
	
    public static Properties getAdditionalProperties() {
        final Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "none");
        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        hibernateProperties.setProperty("hibernate.allow_update_outside_transaction", "true");
        return hibernateProperties;
    }
}
