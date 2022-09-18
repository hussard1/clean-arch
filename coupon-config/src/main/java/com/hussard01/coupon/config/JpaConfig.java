package com.hussard01.coupon.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.hussard01.coupon.infra.repository")
@EntityScan(basePackages = "com.hussard01.coupon.infra.entity")
public class JpaConfig {}
