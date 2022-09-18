package com.hussard01.coupon.core.service;

import com.hussard01.coupon.core.error.CouponNameDuplicateException;
import com.hussard01.coupon.core.error.CouponNotFoundException;
import com.hussard01.coupon.core.model.Coupon;
import com.hussard01.coupon.core.model.CouponSearchParam;
import com.hussard01.coupon.core.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CouponServiceImpl implements CouponService {

  private final CouponRepository couponRepository;

  @Override
  public Coupon create(final Coupon coupon) {
    if (couponRepository.existsByName(coupon.getName())) {
      throw new CouponNameDuplicateException();
    }
    return couponRepository.create(coupon);
  }

  @Override
  public Coupon find(final CouponSearchParam couponSearchParam) {
    return null;
  }

  @Override
  public Coupon use(final Long id) {
    final Coupon coupon = couponRepository.findById(id).orElseThrow(CouponNotFoundException::new);
    coupon.use();
    return coupon;
  }
}
