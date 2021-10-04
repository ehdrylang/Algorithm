package com.tistory.jeongpro.study.week2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IceTest {
    @Test
    public void 공식_테스트() {
        int result = Ice.solution(4, 5, new int[][]{
                {0, 0, 1, 1, 0},
                {0, 0, 0, 1, 1},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}
        });
        Assertions.assertThat(result).isEqualTo(3);
    }

    @Test
    public void 구멍4개_테스트() {
        int result = Ice.solution(4, 5, new int[][]{
                {0, 0, 1, 1, 0},
                {0, 0, 0, 1, 1},
                {1, 1, 1, 1, 1},
                {0, 0, 1, 1, 0}
        });
        Assertions.assertThat(result).isEqualTo(4);
    }
    @Test
    public void 구멍5개_테스트() {
        int result = Ice.solution(4, 5, new int[][]{
                {0, 0, 1, 1, 0},
                {1, 1, 0, 1, 1},
                {1, 1, 1, 1, 1},
                {0, 0, 1, 1, 0}
        });
        Assertions.assertThat(result).isEqualTo(5);
    }
    @Test
    public void 구멍2개_테스트() {
        int result = Ice.solution(3, 4, new int[][]{
                {0, 0, 1, 1},
                {1, 0, 1, 1},
                {0, 0, 1, 0}
        });
        Assertions.assertThat(result).isEqualTo(2);
    }
}