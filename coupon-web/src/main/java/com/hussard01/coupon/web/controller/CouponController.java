package com.hussard01.coupon.web.controller;

import com.hussard01.coupon.core.model.Coupon;
import com.hussard01.coupon.core.service.CouponService;
import com.hussard01.coupon.web.request.CouponCreateReq;
import com.hussard01.coupon.web.request.CouponSearchReq;
import com.hussard01.coupon.web.response.CouponRes;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/coupons")
@Valid
public class CouponController {
  private final CouponService couponService;

  @GetMapping
  public CouponRes coupons(final CouponSearchReq couponSearchReq) {
    return CouponRes.of(couponService.find(couponSearchReq.toCouponSearchParam()));
  }

  @PostMapping("/coupons")
  public CouponRes saveCoupons(@RequestBody final CouponCreateReq couponCreateReq) {
    final Coupon coupon = couponCreateReq.toCoupon();
    return CouponRes.of(couponService.create(coupon));
  }

  @PostMapping("/{id}/use")
  public CouponRes saveCoupons(@PathVariable final Long id) {
    return CouponRes.of(couponService.use(id));
  }
}
