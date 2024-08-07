package com.galavec.ws_gasto_consciente.sources;

import com.galavec.ws_gasto_consciente.component.HibernateProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
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

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.galavec.ws_gasto_consciente.service"})
@EnableJpaRepositories(basePackages = {
        "com.galavec.ws_gasto_consciente.repository"}, entityManagerFactoryRef = "gastoConscienteEntityManager", transactionManagerRef = "gastoConscienteTransactionManager")
public class GastoConscienteData {

    private final HibernateProperties hibernateProperties;
    private final Environment env;

    public GastoConscienteData(HibernateProperties hibernateProperties, Environment env) {
        this.hibernateProperties = hibernateProperties;
        this.env = env;
    }

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

    @Bean
    public DataSource gastoConscienteDataSource() {
        var dataSourceLookup = new JndiDataSourceLookup();
        return dataSourceLookup.getDataSource(Objects.requireNonNull(env.getProperty("gastoConsciente.jndi-name")));
    }

    @Bean
    public PlatformTransactionManager gastoConscienteTransactionManager() {
        var transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(gastoConscienteEntityManager().getObject());
        return transactionManager;
    }
}
