package com.tistory.jeongpro.study.week11;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConveyorBeltTest {
    @Test
    public void 공식테스트() {
        int solution = ConveyorBelt.solution(new int[]{1, 2, 1, 2, 1, 2}, 2);
        Assertions.assertThat(solution).isEqualTo(2);
    }
    @Test
    public void 공식테스트2() {
        int solution = ConveyorBelt.solution(new int[]{100, 99, 60, 80, 30, 20, 10, 89, 99, 100}, 8);
        Assertions.assertThat(solution).isEqualTo(472);
    }

}