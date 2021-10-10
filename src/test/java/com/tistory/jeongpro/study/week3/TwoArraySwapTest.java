package com.tistory.jeongpro.study.week3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TwoArraySwapTest {
    @Test
    public void 공식테스트() {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,5,4,3));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(5,5,6,6,5));
        Assertions.assertThat(TwoArraySwap.solution(list1, list2, 3)).isEqualTo(26L);
    }

}