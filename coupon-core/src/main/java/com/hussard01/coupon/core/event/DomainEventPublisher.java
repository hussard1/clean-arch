package com.hussard01.coupon.core.event;

import org.springframework.context.ApplicationEvent;

public interface DomainEventPublisher {
  <E extends ApplicationEvent> void publish(E event);
}
