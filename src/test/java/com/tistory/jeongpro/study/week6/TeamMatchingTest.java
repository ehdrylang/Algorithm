package com.tistory.jeongpro.study.week6;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

class TeamMatchingTest {
    @Test
    public void 공식테스트() {
        List<Entry<Integer, Entry<Integer, Integer>>> list = new ArrayList<>();
        Entry<Integer, Entry<Integer, Integer>> entry1 = new AbstractMap.SimpleEntry<>(0, new AbstractMap.SimpleEntry<>(1,3));
        Entry<Integer, Entry<Integer, Integer>> entry2 = new AbstractMap.SimpleEntry<>(1, new AbstractMap.SimpleEntry<>(1,7));
        Entry<Integer, Entry<Integer, Integer>> entry3 = new AbstractMap.SimpleEntry<>(0, new AbstractMap.SimpleEntry<>(7,6));
        Entry<Integer, Entry<Integer, Integer>> entry4 = new AbstractMap.SimpleEntry<>(1, new AbstractMap.SimpleEntry<>(7,1));
        Entry<Integer, Entry<Integer, Integer>> entry5 = new AbstractMap.SimpleEntry<>(0, new AbstractMap.SimpleEntry<>(3,7));
        Entry<Integer, Entry<Integer, Integer>> entry6 = new AbstractMap.SimpleEntry<>(0, new AbstractMap.SimpleEntry<>(4,2));
        Entry<Integer, Entry<Integer, Integer>> entry7 = new AbstractMap.SimpleEntry<>(0, new AbstractMap.SimpleEntry<>(1,1));
        Entry<Integer, Entry<Integer, Integer>> entry8 = new AbstractMap.SimpleEntry<>(1, new AbstractMap.SimpleEntry<>(1,1));
        list.add(entry1);
        list.add(entry2);
        list.add(entry3);
        list.add(entry4);
        list.add(entry5);
        list.add(entry6);
        list.add(entry7);
        list.add(entry8);
        Assertions.assertThat(TeamMatching.solution(7, list)).hasSize(3);
        Assertions.assertThat(TeamMatching.solution(7, list)).containsSequence("NO","NO","YES");

    }
}