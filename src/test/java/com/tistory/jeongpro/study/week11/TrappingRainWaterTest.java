package com.tistory.jeongpro.study.week11;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;



class TrappingRainWaterTest {
    @Test
    public void 공식테스트() {
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        int result = trappingRainWater.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        Assertions.assertThat(result).isEqualTo(6);
    }

}