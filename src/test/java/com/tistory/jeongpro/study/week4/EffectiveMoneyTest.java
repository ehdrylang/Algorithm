package com.tistory.jeongpro.study.week4;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EffectiveMoneyTest {
    @Test
    public void 공식테스트() {
        int result = EffectiveMoney.solution(Lists.list(2,3), 6);
        Assertions.assertThat(result).isEqualTo(2);
    }
    @Test
    public void 못만드는수() {
        int result = EffectiveMoney.solution(Lists.list(5,6), 13);
        Assertions.assertThat(result).isEqualTo(-1);
    }
    @Test
    public void 배수() {
        int result = EffectiveMoney.solution(Lists.list(2,4,8), 16);
        Assertions.assertThat(result).isEqualTo(2);
    }

}