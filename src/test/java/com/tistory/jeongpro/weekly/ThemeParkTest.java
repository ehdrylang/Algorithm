package com.tistory.jeongpro.weekly;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThemeParkTest {
    @Test
    public void 테스트() {
        Assertions.assertThat(ThemePark.solution(1,5000, 100)).isEqualTo(50);
    }

}