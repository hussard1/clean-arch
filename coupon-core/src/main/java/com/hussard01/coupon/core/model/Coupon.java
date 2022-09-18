package com.hussard01.coupon.core.model;

import com.hussard01.coupon.core.enums.UseStatus;
import com.hussard01.coupon.core.error.CouponNotUsableException;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class Coupon {
  private long id;
  private String name;
  private LocalDateTime startDateTime;
  private LocalDateTime endDateTime;
  private UseStatus useStatus;

  public Coupon use() {
    this.verifyUsable();
    this.useStatus = UseStatus.USE;
    return this;
  }

  public void verifyUsable() {
    if (!this.useStatus.usable()) {
      throw new CouponNotUsableException();
    }
  }
}
