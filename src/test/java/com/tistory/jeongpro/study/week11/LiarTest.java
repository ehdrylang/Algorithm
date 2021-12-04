package com.tistory.jeongpro.study.week11;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LiarTest {
    @Test
    public void 공식테스트() {
        int solution = Liar.solution(4, new ArrayList<>(), List.of(List.of(1, 2), List.of(3), List.of(2, 3, 4)));
        Assertions.assertThat(solution).isEqualTo(3);
    }

    @Test
    public void 공식테스트2() {
        int solution = Liar.solution(4, List.of(1), List.of(List.of(1, 2, 3, 4)));
        Assertions.assertThat(solution).isEqualTo(0);
    }
}