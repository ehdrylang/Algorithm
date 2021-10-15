package com.tistory.jeongpro.study.week3;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class BadScore {
    public static String[] solution(List<Map.Entry<String, Integer>> scores) {
        return scores.stream()
                .sorted((Comparator.comparingInt(Map.Entry::getValue)))
                .map(Map.Entry::getKey)
                .toArray(String[]::new);
    }
}
