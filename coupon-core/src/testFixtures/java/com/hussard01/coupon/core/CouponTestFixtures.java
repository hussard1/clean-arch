package com.hussard01.coupon.core;

import com.hussard01.coupon.core.enums.UseStatus;
import com.hussard01.coupon.core.model.Coupon;

import java.time.LocalDateTime;

public class CouponTestFixtures {

  public static Coupon coupon() {
    return Coupon.builder()
        .id(11L)
        .name("신규 쿠폰1")
        .saleDateTime(LocalDateTime.now())
        .useStatus(UseStatus.NONE)
        .build();
  }
}
