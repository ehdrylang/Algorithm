package com.tistory.jeongpro.study.week4;

import java.util.Collections;
import java.util.List;

/**
 * 효율적인 화폐 구성
 * 화폐 단위가 주어지고 화폐를 최소한으로 사용하여 목표하는 돈을 만드려고 한다.
 * 최소 몇 개의 화폐 개수가 필요한지 리턴
 * 단, 없으면 -1
 */
public class EffectiveMoney {
    /**
     * @param units  : 화폐 단위
     * @param target : 목표 금액
     * @return
     */
    public static int solution(List<Integer> units, int target) {
        Collections.sort(units);
        int[] memoization = new int[target + 1];
        memoization[0] = 0;
        for(int i=1;i<memoization.length;i++) {
            memoization[i] = 10001; // target의 최대값이 10000이어서 Math.min 사용을 위해 10001로 초기화
        }
        // 1부터 target 까지 최소 화폐단위 시작
        for (int i = 1; i <= target; i++) {
            for (Integer unit : units) {
                if (i - unit >= 0) {
                    memoization[i] = Math.min(memoization[i] , 1 + memoization[i-unit]);
                }
            }
        }
        return memoization[target] == 10001 ? -1 : memoization[target];
    }
}
