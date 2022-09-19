package com.hussard01.coupon.core.event;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.context.ApplicationEvent;

import java.util.UUID;

@Getter
@ToString
public class CouponDomainEvent extends ApplicationEvent {

  private final String eventId;
  private final CouponEventType couponEventType;

  @Builder
  public CouponDomainEvent(final Object source, final CouponEventType couponEventType) {
    super(source);
    this.eventId = UUID.randomUUID().toString();
    this.couponEventType = couponEventType;
  }
}
