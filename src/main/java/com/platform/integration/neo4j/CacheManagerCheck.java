/**
 * Copyright © Altimetrik 2016. All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of Altimetrik. You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms and conditions
 * entered into with Altimetrik.
 */

package com.platform.integration.neo4j;

import javax.cache.CacheManager;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * CacheManagerCheck class.
 * @author Harish Mangala
 */
@Component
public class CacheManagerCheck implements CommandLineRunner {

	private static final Logger logger = Logger.getLogger(CacheManagerCheck.class);

	@Autowired
	private CacheManager cacheManager;

	@Override
	public void run(String... strings) throws Exception {
		logger.info("\n\n" + "=========================================================\n" + "Using cache manager: " + this.cacheManager.getClass().getName() + "\n"
				+ "=========================================================\n\n");
	}

}
