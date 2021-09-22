package com.tistory.jeongpro.study.week1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CardGameTest {
    @Test
    public void 공식_테스트() {
        int[][] array = new int[][]{{3,1,2},{4,1,4},{2,2,2}};
        Assertions.assertThat(CardGame.test(array)).isEqualTo(2);
    }
    @Test
    public void 공식_테스트2() {
        int[][] array = new int[][]{{7,3,1,8},{3,3,3,4}};
        Assertions.assertThat(CardGame.test(array)).isEqualTo(3);
    }

}