package com.tistory.jeongpro.study.week3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TopDownTest {
    @Test
    public void 공식테스트() {
        List<Integer> list = new ArrayList<>();
        list.add(15);
        list.add(27);
        list.add(12);
        Assertions.assertThat(TopDown.solution(list)).containsSubsequence(27,15,12);
    }

}