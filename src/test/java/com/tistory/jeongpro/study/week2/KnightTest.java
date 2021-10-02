package com.tistory.jeongpro.study.week2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnightTest {
    @Test
    public void 공식_테스트(){
        int result = Knight.solution('a', 1);
        Assertions.assertThat(result).isEqualTo(2);

    }

    @Test
    public void A4이면_경우의수는_4다() {
        int result = Knight.solution('a', 4);
        Assertions.assertThat(result).isEqualTo(4);
    }

}