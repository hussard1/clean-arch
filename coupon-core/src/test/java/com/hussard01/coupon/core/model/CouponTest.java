package com.hussard01.coupon.core.model;

import com.hussard01.coupon.core.enums.UseStatus;
import com.hussard01.coupon.core.error.CouponNotUsableException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertThrows;

class CouponTest {

  @Test
  @DisplayName("[쿠폰 사용] 이미 사용한 쿠폰일 경우")
  void test_coupon_use() {
    // given
    final Coupon coupon =
        Coupon.builder()
            .id(11L)
            .name("신규 쿠폰1")
            .saleDateTime(LocalDateTime.now())
            .useStatus(UseStatus.USE)
            .build();
    // when // then
    assertThrows(CouponNotUsableException.class, coupon::use);
  }
}
