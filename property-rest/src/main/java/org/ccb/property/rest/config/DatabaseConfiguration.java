package org.ccb.property.rest.config;

import org.ccb.core.repository.impl.PersistableRepositoryImpl;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(
		basePackages = {"org.ccb.**.repository"},
		repositoryBaseClass = PersistableRepositoryImpl.class)
@EntityScan("org.ccb.**.model")
@EnableJpaAuditing
@EnableTransactionManagement
public class DatabaseConfiguration {

}
