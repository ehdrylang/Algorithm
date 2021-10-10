package com.tistory.jeongpro.study.week3;

import org.thymeleaf.expression.Lists;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 위에서 아래로
 */
public class TopDown {
    public static int[] solution(List<Integer> array) {
        return array.stream()
                .sorted((o1, o2) -> o2 - o1)
                .mapToInt(integer -> integer)
                .toArray();
    }
}
