package com.hussard01.coupon.core.repository;

import com.hussard01.coupon.core.model.Coupon;
import com.hussard01.coupon.core.model.CouponSearchParam;

import java.util.List;
import java.util.Optional;

public interface CouponRepository {
  Coupon create(Coupon coupon);

  Optional<Coupon> findById(Long id);

  boolean existsByName(String name);

  List<Coupon> findBy(CouponSearchParam couponSearchParam);
}
