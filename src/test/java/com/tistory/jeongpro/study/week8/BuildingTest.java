package com.tistory.jeongpro.study.week8;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuildingTest {
    @Test
    public void 공식테스트1() {
        int solution = Building.solution(new double[]{1, 5, 3L, 2L, 6L, 3L, 2L, 6L, 4L, 2L, 5L, 7L, 3L, 1L, 5L});
        Assertions.assertThat(solution).isEqualTo(7);
    }

}