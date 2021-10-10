package com.tistory.jeongpro.study.week3;

import java.util.Collections;
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

    public static String solution2(List<Integer> components, int n, List<Integer> wants, int m) {
        Collections.sort(components);
        StringBuilder sb = new StringBuilder();
        for (Integer value : wants) {
            boolean exist = search(components, 0, components.size() - 1, value);
            if (exist) {
                sb.append("yes ");
            } else {
                sb.append("no ");
            }
        }
        return sb.toString().trim();
    }
    // 1,2,3,4,5   0, 4
    // 1,3,4,2     0, 3
    private static boolean search(List<Integer> list, int startIdx, int endIndex, int searchValue) {
        if(startIdx <= endIndex) {
            int midIndex = (startIdx + endIndex) / 2;
            int midValue = list.get(midIndex);
            if (midValue == searchValue) {
                return true;
            }
            if(midValue < searchValue) {
                startIdx = midIndex + 1;
            } else {
                endIndex = midIndex - 1;
            }
            return search(list, startIdx, endIndex, searchValue);
        }
        return false;
    }
}
