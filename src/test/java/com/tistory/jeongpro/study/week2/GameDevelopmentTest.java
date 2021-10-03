package com.tistory.jeongpro.study.week2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameDevelopmentTest {
    @Test
    public void 공식_테스트() {
        int result = GameDevelopment.solution(new boolean[][]{
                {true, true, true, true},
                {true, false, false, true},
                {true, true, false, true},
                {true, true, true, true}}, 1, 1, 0);
        Assertions.assertThat(result).isEqualTo(3);
    }

}