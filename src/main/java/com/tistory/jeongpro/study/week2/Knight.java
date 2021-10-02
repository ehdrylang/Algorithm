package com.tistory.jeongpro.study.week2;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 왕실의 나이트
 * 주어진 좌표에서 이동 가능한 경우의 수 출력
 */
public class Knight {
    public static int solution(char cx, int y) {
        int x = cx - (int) 'a' + 1;
        List<Map.Entry<Integer, Integer>> points = new ArrayList<>();
        points.add(new AbstractMap.SimpleEntry<>(1, 2));
        points.add(new AbstractMap.SimpleEntry<>(-1, 2));
        points.add(new AbstractMap.SimpleEntry<>(-2, 1));
        points.add(new AbstractMap.SimpleEntry<>(-2, -1));
        points.add(new AbstractMap.SimpleEntry<>(1, -2));
        points.add(new AbstractMap.SimpleEntry<>(-1, -2));
        points.add(new AbstractMap.SimpleEntry<>(2, 1));
        points.add(new AbstractMap.SimpleEntry<>(2, -1));

        long count = points.stream()
                .filter(entry -> isValid(x + entry.getKey(), y + entry.getValue()))
                .count();
        return (int) count;
    }

    private static boolean isValid(int x, int y) {
        return x >= 1 && x <= 8 && y >= 1 && y <= 8;
    }
}
