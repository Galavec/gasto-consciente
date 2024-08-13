package com.galavec.ws_gasto_consciente.sources;

import com.galavec.ws_gasto_consciente.component.HibernateProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Map;
import java.util.Objects;

/**
 * Clase que gestiona la conexión hacia la base de datos "gasto-consciente" mediante el jndi.
 *
 * @author Héctor Galavec
 * @version 1.0.0
 * @since 1.0.0
 */
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.galavec.ws_gasto_consciente.service"})
@EnableJpaRepositories(basePackages = {
        "com.galavec.ws_gasto_consciente.repository"}, entityManagerFactoryRef = "gastoConscienteEntityManager", transactionManagerRef = "gastoConscienteTransactionManager")
public class GastoConscienteData {

    private final HibernateProperties hibernateProperties;
    private final Environment env;

    /**
     * Constructor público para crear instancias.
     *
     * @param hibernateProperties obtiene las propiedades y valores para Hibernate.
     * @param env                 variable Environment para obtener los datos desde el properties.
     * @author Héctor Galavec
     * @see HibernateProperties
     * @since 1.0.0
     */
    public GastoConscienteData(HibernateProperties hibernateProperties, Environment env) {
        this.hibernateProperties = hibernateProperties;
        this.env = env;
    }

    /**
     * Para obtener: las propiedades/valores para Hibernate y el dialecto Hibernate de postgresql.
     *
     * @return configuración de los dataSource y escaneo de los paquetes entity.
     * @author Héctor Galavec
     * @see HibernateProperties
     * @since 1.0.0
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean gastoConscienteEntityManager() {
        var localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        localContainerEntityManagerFactoryBean.setDataSource(gastoConscienteDataSource());
        localContainerEntityManagerFactoryBean.setPackagesToScan("com.galavec.ws_gasto_consciente.entity");

        Map<String, Object> properties = hibernateProperties.toMap();

        properties.put("hibernate.dialect", env.getProperty("postgre.hibernate.dialect"));

        BaseData.entityProperties(localContainerEntityManagerFactoryBean, properties);

        return localContainerEntityManagerFactoryBean;
    }

    /**
     * Para obtener la conexión de la base de datos "gasto-consciente" mediante el jndi.
     *
     * @return el dataSource obtenido mediante el jndi.
     * @author Héctor Galavec
     * @since 1.0.0
     */
    @Bean
    public DataSource gastoConscienteDataSource() {
        var dataSourceLookup = new JndiDataSourceLookup();
        return dataSourceLookup.getDataSource(Objects.requireNonNull(env.getProperty("gastoConsciente.jndi-name")));
    }

    /**
     * Para configurar el JpaTransactionManager.
     *
     * @return propiedades como entityManagerFactory.
     * @author Héctor Galavec
     * @since 1.0.0
     */
    @Bean
    public PlatformTransactionManager gastoConscienteTransactionManager() {
        var transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(gastoConscienteEntityManager().getObject());
        return transactionManager;
    }
}
