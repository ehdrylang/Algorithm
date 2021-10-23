package com.tistory.jeongpro.study.week5;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class SalesAndMeetingTest {
    @Test
    public void 공식테스트() {
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>();
        list.add(new AbstractMap.SimpleEntry<>(1,2));
        list.add(new AbstractMap.SimpleEntry<>(1,3));
        list.add(new AbstractMap.SimpleEntry<>(1,4));
        list.add(new AbstractMap.SimpleEntry<>(2,4));
        list.add(new AbstractMap.SimpleEntry<>(3,4));
        list.add(new AbstractMap.SimpleEntry<>(3,5));
        list.add(new AbstractMap.SimpleEntry<>(4,5));
        int solution = SalesAndMeeting.solution(5, list, 5, 4);
        Assertions.assertThat(solution).isEqualTo(3);
    }

}