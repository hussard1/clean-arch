package com.hussard01.coupon.infra.repository;

import com.hussard01.coupon.infra.entity.CouponEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface CouponJpaRepository extends JpaRepository<CouponEntity, Long> {
  boolean existsByName(String name);

  List<CouponEntity> findBySaleDateTimeBetween(
      LocalDateTime startDateTime, LocalDateTime endDateTime);
}
