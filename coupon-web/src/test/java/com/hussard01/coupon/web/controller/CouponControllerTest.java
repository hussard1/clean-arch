package com.hussard01.coupon.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hussard01.coupon.core.CouponTestFixtures;
import com.hussard01.coupon.core.model.Coupon;
import com.hussard01.coupon.core.service.CouponService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = CouponController.class)
class CouponControllerTest {

  @Autowired private MockMvc mockMvc;
  @Autowired private ObjectMapper objectMapper;
  @MockBean private CouponService couponService;

  @Test
  @DisplayName("[쿠폰 생성] 정상 동작")
  void testCreateCoupon() throws Exception {
    final Coupon coupon = CouponTestFixtures.coupon();
    // given
    given(couponService.create(any())).willReturn(coupon);
    // when // then
    mockMvc
        .perform(
            post("/coupons")
                .header("Content-Type", "application/json")
                .content(objectMapper.writeValueAsString(coupon)))
        .andExpect(status().isOk())
        .andDo(print());
  }
}
