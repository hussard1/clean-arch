package com.hussard01.coupon.core.model;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class CouponSearchParam {
  public LocalDateTime startDateTime;
  public LocalDateTime endDateTime;
}
