package com.hussard01.coupon.infra;

import com.hussard01.coupon.core.model.Coupon;
import com.hussard01.coupon.core.model.CouponSearchParam;
import com.hussard01.coupon.core.repository.CouponRepository;
import com.hussard01.coupon.infra.entity.CouponEntity;
import com.hussard01.coupon.infra.repository.CouponJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CouponRepositoryImpl implements CouponRepository {

  public final CouponJpaRepository couponJpaRepository;

  @Override
  public Coupon create(final Coupon coupon) {
    final CouponEntity couponEntity = CouponEntity.of(coupon);
    return couponJpaRepository.save(couponEntity).toCoupon();
  }

  @Override
  public Optional<Coupon> findById(final Long id) {
    return couponJpaRepository.findById(id).map(CouponEntity::toCoupon);
  }

  @Override
  public boolean existsByName(final String name) {
    return couponJpaRepository.existsByName(name);
  }

  @Override
  public List<Coupon> findBy(final CouponSearchParam couponSearchParam) {
    return couponJpaRepository
        .findBySaleDateTimeBetween(
            couponSearchParam.getStartDateTime(), couponSearchParam.getEndDateTime())
        .stream()
        .map(CouponEntity::toCoupon)
        .collect(Collectors.toList());
  }
}
