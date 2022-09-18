package com.hussard01.coupon.core.service;

import com.hussard01.coupon.core.model.Coupon;
import com.hussard01.coupon.core.model.CouponSearchParam;

public interface CouponService {
  Coupon create(Coupon coupon);

  Coupon find(CouponSearchParam couponSearchParam);

  Coupon use(Long id);
}
