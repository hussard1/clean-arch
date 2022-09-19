package com.hussard01.coupon.core.service;

import com.hussard01.coupon.core.CouponTestFixtures;
import com.hussard01.coupon.core.enums.UseStatus;
import com.hussard01.coupon.core.error.CouponNameDuplicateException;
import com.hussard01.coupon.core.error.CouponNotFoundException;
import com.hussard01.coupon.core.event.CouponDomainEventPublisher;
import com.hussard01.coupon.core.model.Coupon;
import com.hussard01.coupon.core.repository.CouponRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
class CouponServiceImplTest {

  @MockBean private CouponRepository couponRepository;
  @MockBean private CouponDomainEventPublisher couponDomainEventPublisher;

  private CouponServiceImpl couponService;

  @BeforeEach
  void setUp() {
    couponService = new CouponServiceImpl(couponRepository, couponDomainEventPublisher);
  }

  @Test
  @DisplayName("[쿠폰 생성] 쿠폰이 같은 이름이 있을 경우")
  void test_create_coupon_duplicate_name() {
    // given
    final Coupon coupon = CouponTestFixtures.coupon();
    given(couponRepository.existsByName(any())).willReturn(true);
    // when // then
    assertThrows(CouponNameDuplicateException.class, () -> couponService.create(coupon));
  }

  @Test
  @DisplayName("[쿠폰 생성] 정상 동작")
  void test_coupon_create() {
    // given
    final Coupon coupon = CouponTestFixtures.coupon();
    given(couponRepository.existsByName(any())).willReturn(false);
    given(couponRepository.create(any())).willReturn(coupon);
    // when
    final Coupon result = couponService.create(coupon);
    // then
    verify(couponDomainEventPublisher, times(1)).publish(any());
    assertThat(result.getId()).isEqualTo(coupon.getId());
    assertThat(result.getName()).isEqualTo(coupon.getName());
    assertThat(result.getSaleDateTime()).isEqualTo(coupon.getSaleDateTime());
    assertThat(result.getUseStatus()).isEqualTo(coupon.getUseStatus());
  }

  @Test
  @DisplayName("[쿠폰 사용] 사용이 없을 경우")
  void test_coupon_use_not_found() {
    // given
    given(couponRepository.findById(anyLong())).willReturn(Optional.empty());
    // when // then
    assertThrows(CouponNotFoundException.class, () -> couponService.use(1L));
  }

  @Test
  @DisplayName("[쿠폰 사용] 정상 동작")
  void test_coupon_use() {
    // given
    final Coupon coupon = CouponTestFixtures.coupon();
    given(couponRepository.findById(any())).willReturn(Optional.of(coupon));
    // when
    final Coupon result = couponService.use(coupon.getId());
    // then
    verify(couponDomainEventPublisher, times(1)).publish(any());
    assertThat(result.getId()).isEqualTo(coupon.getId());
    assertThat(result.getName()).isEqualTo(coupon.getName());
    assertThat(result.getSaleDateTime()).isEqualTo(coupon.getSaleDateTime());
    assertThat(result.getUseStatus()).isEqualTo(UseStatus.USE);
  }
}
