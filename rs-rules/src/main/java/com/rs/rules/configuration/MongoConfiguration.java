package com.rs.rules.configuration;

import com.rs.core.persistence.mongo.BaseMongoRepositoryFactoryBean;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@Order(Ordered.HIGHEST_PRECEDENCE)
@PropertySource("classpath:mongo.properties")
@EnableMongoRepositories(basePackages = "com.rs.rules", repositoryFactoryBeanClass = BaseMongoRepositoryFactoryBean.class)
public class MongoConfiguration extends AbstractMongoConfiguration {

    @Value("${mongo.host}")
    protected String host;
    @Value("${mongo.database}")
    protected String dbName;

    @Override
    protected String getDatabaseName() {
        return dbName;
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient(host);
    }
}