package com.tistory.jeongpro.study.week7;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class SafeAreaTest {
    @Test
    public void 공식테스트() {
        int solution = SafeArea.solution(new int[][]{
                {6, 8, 2, 6, 2},
                {3, 2, 3, 4, 6},
                {6, 7, 3, 3, 2},
                {7, 2, 5, 3, 6},
                {8, 9, 5, 2, 7}
        });
        Assertions.assertThat(solution).isEqualTo(5);
    }
}
