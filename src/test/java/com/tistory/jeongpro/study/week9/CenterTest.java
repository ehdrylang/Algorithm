package com.tistory.jeongpro.study.week9;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CenterTest {
    @Test
    public void 공식테스트() {
        int solution = Center.solution(new int[][]{
                {0, 0, 0, 0, 0, 0,},
                {1, 0, 0, 0, 0, 2,},
                {1, 1, 1, 0, 0, 2,},
                {0, 0, 0, 0, 0, 2}
        });
        Assertions.assertThat(solution).isEqualTo(9);
    }
}