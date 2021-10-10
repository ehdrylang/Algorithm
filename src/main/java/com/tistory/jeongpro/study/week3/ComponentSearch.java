package com.tistory.jeongpro.study.week3;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 부품 찾기
 */
public class ComponentSearch {
    public static String solution(List<Integer> components, int n, List<Integer> wants, int m) {
        Set<Integer> stocks = new HashSet<>(components);
        return wants.stream()
                .map(i -> stocks.contains(i) ? "yes" : "no")
                .collect(Collectors.joining(" "));
    }
}
