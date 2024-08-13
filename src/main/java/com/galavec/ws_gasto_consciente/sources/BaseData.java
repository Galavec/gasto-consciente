package com.galavec.ws_gasto_consciente.sources;

import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import java.util.Map;

/**
 * Clase que gestiona las propiedades entity para Hibernate.
 *
 * @author Héctor Galavec
 * @version 1.0.0
 * @since 1.0.0
 */
public class BaseData {
    /**
     * Constructor privado para evitar instancias.
     *
     * @throws AssertionError para evitar que se creen instancias de esta clase
     * @author Héctor Galavec
     * @since 1.0.0
     */
    private BaseData() {
        throw new AssertionError("No se permiten instancias.");
    }

    /**
     * Gestiona las propiedades entity para Hibernate.
     *
     * @param localContainerEntityManagerFactoryBean para establecer el adaptador de proveedor JPA (vendorAdapter) y un mapa de propiedades JPA (properties).
     * @param properties                             contiene propiedades de configuración específicas para JPA y Hibernate.
     * @author Héctor Galavec
     * @since 1.0.0
     */
    static void entityProperties(LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean, Map<String, Object> properties) {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();

        localContainerEntityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
        localContainerEntityManagerFactoryBean.setJpaPropertyMap(properties);
    }
}
