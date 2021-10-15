package com.tistory.jeongpro.study.week4;

import java.util.ArrayList;
import java.util.List;

/**
 * 개미전사
 * 메뚜기 식량 창고 배열 주어짐
 * 털어버린 창고 양 옆은 눈치채서 못 터니 3개 골랐을 때 최솟값인 곳을 털어야 이득?
 */
public class AntWarrior {
    public static int solution(List<Integer> quantities) {
        int[] memoization = new int[quantities.size() + 1];
        memoization[1] = quantities.get(0);
        memoization[2] = Math.max(memoization[1], quantities.get(1));
        for (int i = 2 ; i < quantities.size(); i++) {
            memoization[i+1] = Math.max(memoization[i], memoization[i-1] + quantities.get(i));
        }
        return memoization[quantities.size()];
    }
}
