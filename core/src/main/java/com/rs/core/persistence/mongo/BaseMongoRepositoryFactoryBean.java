package com.rs.core.persistence.mongo;

import com.rs.core.persistence.mongo.impl.BaseMongoRepositoryImpl;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.support.MongoRepositoryFactory;
import org.springframework.data.mongodb.repository.support.MongoRepositoryFactoryBean;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import java.io.Serializable;

/**
 * Author: Oleh Osyka
 * Date: 4/13/2016
 * Time: 1:32 PM
 */
public class BaseMongoRepositoryFactoryBean<R extends MongoRepository<T, I>, T, I extends Serializable>
        extends MongoRepositoryFactoryBean<R, T, I> {

    @Override
    protected RepositoryFactorySupport getFactoryInstance(MongoOperations operations) {
        return new BaseMongoRepositoryFactory(operations);
    }

    private static class BaseMongoRepositoryFactory<T, I extends Serializable> extends MongoRepositoryFactory {

        private MongoOperations mongoOperations;

        public BaseMongoRepositoryFactory(MongoOperations mongoOperations) {
            super(mongoOperations);
            this.mongoOperations = mongoOperations;
        }

        @Override
        protected Object getTargetRepository(RepositoryInformation information) {
            return new BaseMongoRepositoryImpl<>(getEntityInformation(information.getDomainType()), mongoOperations);
        }

        protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
            return BaseMongoRepository.class;
        }
    }
}
