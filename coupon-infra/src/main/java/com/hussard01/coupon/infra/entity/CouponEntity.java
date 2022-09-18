package com.hussard01.coupon.infra.entity;

import com.hussard01.coupon.core.model.Coupon;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CouponEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private LocalDateTime saleDateTime;

  public static CouponEntity of(final Coupon coupon) {
    return CouponEntity.builder()
        .name(coupon.getName())
        .saleDateTime(coupon.getSaleDateTime())
        .build();
  }

  public Coupon toCoupon() {
    return Coupon.builder().id(this.id).name(this.name).saleDateTime(this.saleDateTime).build();
  }
}
