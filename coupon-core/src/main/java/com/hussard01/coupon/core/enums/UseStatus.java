package com.hussard01.coupon.core.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum UseStatus {
  NONE,
  USE,
  CANCEL;

  public boolean usable() {
    return this == NONE || this == CANCEL;
  }
}
