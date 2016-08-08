/**
 * Copyright © Altimetrik 2016. All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of Altimetrik. You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms and conditions
 * entered into with Altimetrik.
 */

package com.platform.integration.neo4j;

import org.apache.log4j.Logger;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;

/**
 * Class for code based configuration of Spring managed Neo4j infrastructure.
 * <p>
 * Subclasses are required to provide an implementation of graphDbService ....
 * @author Harish Mangala
 */
@EnableCaching
@SpringBootApplication
@EnableNeo4jRepositories
public abstract class Neo4jApplication extends Neo4jConfiguration {
	static Logger logger = Logger.getLogger(Neo4jApplication.class);

	/**
	 * Application Constructor to load base packages.
	 * @param basePackage String
	 */
	public Neo4jApplication(String basePackage) {
		setBasePackage(basePackage);
	}

	/**
	 * Initialize Graph Database.
	 * @return Graph Database Factory
	 */
	@Bean(destroyMethod = "shutdown")
	public GraphDatabaseService graphDatabaseService() {
		return new GraphDatabaseFactory().newEmbeddedDatabase("target/entity.db");
	}

	/**
	 * Create Embedded Servlet Container.
	 * @return servletContainer Bean
	 */
	@Bean
	public EmbeddedServletContainerFactory servletContainer() {
		return new TomcatEmbeddedServletContainerFactory();
	}

	public static void main(String[] args) {
		logger.info("\n\n" + "=========================================================\n" + "Using Neo4jApplication: \n"
				+ "=========================================================\n\n");
	}

}
