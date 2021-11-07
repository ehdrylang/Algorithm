package com.tistory.jeongpro.study.week7;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FreedomTest {
    @Test
    public void 공식테스트() {
        int result = Freedom.solution(new int[][]{
                {3,10},
                {5,20},
                {1,10},
                {1,20},
                {2,15},
                {4,40},
                {2,200}
        });
        Assertions.assertThat(result).isEqualTo(45);
    }
}