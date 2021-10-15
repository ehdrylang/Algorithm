package com.tistory.jeongpro.study.week4;

import java.util.HashMap;
import java.util.Map;

/**
 * 1로 만들기
 * 할 수 있는 연산 4가지
 * X가 5로 나누어떨어지면, 5로 나눈다.
 * X가 3으로 나누어떨어지면, 3으로 나눈다.
 * X가 2로 나누어떨어지면, 2로 나눈다.
 * X에서 1을 뺀다.
 * <p>
 * 첫번째 접근 : 1부터 최적인 애들로만 계산해보면 되지 않을까? = 잘못된 접근
 */
public class ToOne {
    public static int solution(int x) {
        int result = 0;
        int[] memoization = new int[x + 1];
        memoization[0] = 0;
        memoization[1] = 0;
        for (int i = 2; i <= x; i++) {
            memoization[i] = 1 + memoization[i - 1];
            if (i % 2 == 0) {
                memoization[i] = Math.min(memoization[i], 1 + memoization[i / 2]);
            }
            if (i % 3 == 0) {
                memoization[i] = Math.min(memoization[i], 1 + memoization[i / 3]);
            }
            if (i % 5 == 0) {
                memoization[i] = Math.min(memoization[i], 1 + memoization[i / 5]);
            }
        }
        return memoization[x];
    }
}
