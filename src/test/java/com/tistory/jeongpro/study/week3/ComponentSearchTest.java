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
    @Test
    public void 공식테스트solution2() {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(8,3,7,9,1));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(5,7,9));
        Assertions.assertThat(ComponentSearch.solution2(list1, 5, list2, 3)).isEqualTo("no yes yes");
    }

    @Test
    public void 임의테스트solution2() {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(8,3,7,9,1,2,6));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(5,7,9,6,11));
        Assertions.assertThat(ComponentSearch.solution2(list1, 5, list2, 3)).isEqualTo("no yes yes yes no");
    }

    @Test
    public void 중복테스트solution2() {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(8,3,3,4,1,4,6));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(5,7,3,6,4));
        Assertions.assertThat(ComponentSearch.solution2(list1, 5, list2, 3)).isEqualTo("no no yes yes yes");
    }


}