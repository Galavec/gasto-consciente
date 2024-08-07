package com.galavec.ws_gasto_consciente.component;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Getter
@Component
public class HibernateProperties {
    @Value("${hibernate.jdbc.lob.non_contextual_creation}")
    private String lobNonContextualCreation;

    @Value("${hibernate.generate_statistics}")
    private String generateStatistics;

    @Value("${hibernate.use_sql_comments}")
    private String useSqlComments;

    @Value("${hibernate.format_sql}")
    private String formatSql;

    @Value("${hibernate.ddl-auto}")
    private String ddlAuto;

    @Value("${hibernate.show_sql}")
    private String showSql;

    public Map<String, Object> toMap() {
        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.jdbc.lob.non_contextual_creation", lobNonContextualCreation);
        properties.put("hibernate.generate_statistics", generateStatistics);
        properties.put("hibernate.use_sql_comments", useSqlComments);
        properties.put("hibernate.format_sql", formatSql);
        properties.put("hibernate.ddl-auto", ddlAuto);
        properties.put("hibernate.show_sql", showSql);
        return properties;
    }
}
