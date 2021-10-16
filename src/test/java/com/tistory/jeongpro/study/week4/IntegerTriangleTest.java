package com.tistory.jeongpro.study.week4;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerTriangleTest {
    @Test
    public void 공식테스트() {
        int result = IntegerTriangle.solution(new int[][]{
                {7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}
        });
        Assertions.assertThat(result).isEqualTo(30);
    }
    @Test
    public void 삼각형의높이가1일때() {
        int result = IntegerTriangle.solution(new int[][]{
                {7}
        });
        Assertions.assertThat(result).isEqualTo(7);
    }


}