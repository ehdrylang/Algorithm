package com.tistory.jeongpro.study.week3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ComponentSearchTest {
    @Test
    public void 공식테스트() {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(8,3,7,9,1));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(5,7,9));
        Assertions.assertThat(ComponentSearch.solution(list1, 5, list2, 3)).isEqualTo("no yes yes");
    }


}