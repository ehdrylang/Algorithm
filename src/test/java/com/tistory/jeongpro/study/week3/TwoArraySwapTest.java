package com.tistory.jeongpro.study.week3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class TwoArraySwapTest {
    @Test
    public void 공식테스트() {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(5);
        list1.add(4);
        list1.add(3);
        List<Integer> list2 = new ArrayList<>();
        list2.add(5);
        list2.add(5);
        list2.add(6);
        list2.add(6);
        list2.add(5);
        Assertions.assertThat(TwoArraySwap.solution(list1, list2, 3)).isEqualTo(26L);
    }

}