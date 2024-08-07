package com.galavec.ws_gasto_consciente.sources;

import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import java.util.Map;

public class BaseData {
    // Constructor privado para evitar instantiation.
    private BaseData() {
        throw new AssertionError("No instances allowed.");
    }

    static void entityProperties(LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean, Map<String, Object> properties) {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();

        localContainerEntityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
        localContainerEntityManagerFactoryBean.setJpaPropertyMap(properties);
    }
}
