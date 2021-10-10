package com.tistory.jeongpro.study.week3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class BadScoreTest {
    @Test
    public void 공식테스트(){
        List<Map.Entry<String, Integer>> list = new ArrayList<>();
        list.add(new AbstractMap.SimpleEntry<>("홍길동", 95));
        list.add(new AbstractMap.SimpleEntry<>("이순신", 77));
        list.add(new AbstractMap.SimpleEntry<>("AAA", 79));
        Assertions.assertThat(BadScore.solution(list)).containsSequence("이순신","AAA","홍길동");
    }
}