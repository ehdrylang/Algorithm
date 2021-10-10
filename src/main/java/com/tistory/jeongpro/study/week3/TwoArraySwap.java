package com.tistory.jeongpro.study.week3;

import java.util.Collections;
import java.util.List;

/**
 * 두 배열의 원소 교체
 */
public class TwoArraySwap {
    public static long solution(List<Integer> a, List<Integer> b, int k) {
        Collections.sort(a);
        Collections.sort(b);
        Collections.reverse(b);
        int count = 0;
        for (int i = 0; i < k; i++) {
            Integer v1 = a.get(i);
            Integer v2 = b.get(i);
            if (v1 < v2) {
                count++;
                a.add(v2);
            }
        }
        for (int i = 0; i < count; i++) {
            a.remove(0);
        }
        return a.stream().mapToLong(Integer::longValue).sum();
    }

}
