package com.hussard01.coupon.web.request;

import com.hussard01.coupon.core.model.Coupon;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Builder
public class CouponCreateReq {

  @NotBlank public String name;

  @NotNull public LocalDateTime saleDateTime;

  public Coupon toCoupon() {
    return Coupon.builder().name(this.name).saleDateTime(this.saleDateTime).build();
  }
}
