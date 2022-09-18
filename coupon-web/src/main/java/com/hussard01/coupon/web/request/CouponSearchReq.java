package com.hussard01.coupon.web.request;

import com.hussard01.coupon.core.model.CouponSearchParam;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
public class CouponSearchReq {

  @NotNull public LocalDateTime startDateTime;

  @NotNull public LocalDateTime endDateTime;

  public CouponSearchParam toCouponSearchParam() {
    return CouponSearchParam.builder()
        .startDateTime(this.startDateTime)
        .endDateTime(this.endDateTime)
        .build();
  }
}
