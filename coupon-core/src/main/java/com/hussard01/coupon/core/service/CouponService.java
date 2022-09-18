package com.hussard01.coupon.core.service;

import com.hussard01.coupon.core.model.Coupon;
import com.hussard01.coupon.core.model.CouponSearchParam;

import java.util.List;

public interface CouponService {
  List<Coupon> findBy(CouponSearchParam couponSearchParam);

  Coupon create(Coupon coupon);

  Coupon use(Long id);
}
