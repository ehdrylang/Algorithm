package com.tistory.jeongpro.study.week4;

/**
 * 바닥 공사
 * 가로 N, 세로 2
 * 1*2 , 2*1 , 2*2 타일로 덮을 수 있는 경우의 수 세기
 * 결과는 796796으로 나눈 나머지 출력
 */
public class Tile {
    public static int solution(int n) {
        // 1일 때 = 1개
        int[] memoization = new int[n+1];
        memoization[1] = 1;
        memoization[2] = 3;
        for (int i=3;i<=n;i++){
            memoization[i] = memoization[i-1] + 2 * memoization[i-2] % 796796;
        }
        return memoization[n];
    }
}
