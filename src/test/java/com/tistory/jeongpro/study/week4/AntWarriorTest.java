package com.tistory.jeongpro.study.week4;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class AntWarriorTest {
    @Test
    public void 공식테스트() {
        int solution = AntWarrior.solution(List.of(1, 3, 1, 5));
        Assertions.assertThat(solution).isEqualTo(8);
    }

}