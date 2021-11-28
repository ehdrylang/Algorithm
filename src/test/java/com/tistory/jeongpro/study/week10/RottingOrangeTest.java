package com.tistory.jeongpro.study.week10;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RottingOrangeTest {
    @Test
    public void 공식테스트() {
        RottingOrange rottingOrange = new RottingOrange();
        int sec = rottingOrange.orangesRotting(new int[][]{
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        });
        Assertions.assertThat(sec).isEqualTo(4);
    }

}