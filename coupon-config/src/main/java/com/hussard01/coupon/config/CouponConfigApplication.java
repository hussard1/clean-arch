package com.hussard01.coupon.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.hussard01.coupon")
public class CouponConfigApplication {

  public static void main(final String[] args) {
    SpringApplication.run(CouponConfigApplication.class, args);
  }
}
