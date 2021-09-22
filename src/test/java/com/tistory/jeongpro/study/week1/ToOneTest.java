package com.tistory.jeongpro.study.week1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ToOneTest {
    @Test
    public void 공식_테스트() {
        Assertions.assertThat(ToOne.test(25,5)).isEqualTo(2);
    }

}