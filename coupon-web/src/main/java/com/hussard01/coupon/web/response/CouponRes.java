package com.hussard01.coupon.web.response;

import com.hussard01.coupon.core.model.Coupon;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class CouponRes {
  public final long id;
  public final String name;

  public final LocalDateTime startDateTime;
  public final LocalDateTime endDateTime;

  public static CouponRes of(final Coupon coupon) {
    return CouponRes.builder()
        .name(coupon.getName())
        .startDateTime(coupon.getStartDateTime())
        .endDateTime(coupon.getEndDateTime())
        .build();
  }
}
