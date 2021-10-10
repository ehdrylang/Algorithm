package com.tistory.jeongpro.study.week3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.OptionalInt;

/**
 * 떡볶이 떡 자르기
 */
public class Cutter {
    private static List<Integer> candidates;

    public static int solution(List<Integer> lengths, int requestedLength) {
        Collections.sort(lengths);
        candidates = new ArrayList<>();
        cut(lengths, lengths.get(0), lengths.get(lengths.size() - 1), requestedLength);
        OptionalInt max = candidates.stream().mapToInt(x -> x).max();
        return max.orElse(0);
    }

    // 1,3,5,7,9 3cm = 6으로 잘라야하는데?
    // 1,2,'3',4,5   mid = 2
    // 1,2,3,4,5,6,7,8,9,10,11,12,1000000
    private static void cut(List<Integer> lengths, int min, int max, int requestedLength) {
        if (min < max) {
            int mid = (min + max) / 2;
            int sum = 0;
            for (Integer i : lengths) {
                sum += Math.max((i - mid), 0);
            }
            if (sum < requestedLength) {
                cut(lengths, min, mid - 1, requestedLength);
            } else {
                cut(lengths, mid + 1, max, requestedLength);
                candidates.add(mid);
            }
        }
    }
}
