package com.tistory.jeongpro.study.week10;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DiceTest {
    @Test
    public void 공식테스트() {
        List<Integer> solution = Dice.solution(List.of(4, 4, 4, 1, 3, 3, 3, 2), new int[][]{
                {0, 2},
                {3, 4},
                {5, 6},
                {7, 8}
        }, 0, 0);
        Assertions.assertThat(solution).containsSequence(0,0,3,0,0,8,6,3);
    }
}