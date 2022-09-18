package com.hussard01.coupon.web.response;

import com.hussard01.coupon.core.model.Coupon;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class CouponRes {
  public final long id;
  public final String name;

  public final LocalDateTime saleDateTime;

  public static CouponRes of(final Coupon coupon) {
    return CouponRes.builder()
        .name(coupon.getName())
        .saleDateTime(coupon.getSaleDateTime())
        .build();
  }

  public static List<CouponRes> listOf(final List<Coupon> coupons) {
    return coupons.stream().map(CouponRes::of).toList();
  }
}
