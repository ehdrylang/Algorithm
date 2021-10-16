package com.tistory.jeongpro.study.week4;

import java.util.Arrays;

/**
 * 정수 삼각형
 * 0~9999 범위에 있는 정수가 담긴 2차원 배열(이진트리 모양)이 주어지고
 * 이진트리 처럼 아래로 진행할 수 있는데 결국 최종 노드까지 주어진 정수 값을 더해가면서 최대가 되는 경우의 값을 리턴한다.
 */
public class IntegerTriangle {
    public static int solution(int[][] triangle) {
        int answer = 0;
        int total = 0;
        for(int i=1;i<=triangle.length;i++) {
            total += i;
        }
        int[] memoization = new int[total];
        int idx = 0;
        memoization[idx] = triangle[0][0];
        for (int i = 0; i < triangle.length - 1; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                memoization[idx+i+1] = Math.max(memoization[idx+i+1], memoization[idx] + triangle[i+1][j]); // 왼쪽
                memoization[idx+i+2] = Math.max(memoization[idx+i+2], memoization[idx] + triangle[i+1][j+1]); // 오른쪽
                idx++;
            }
        }
        Arrays.sort(memoization);
        return memoization[memoization.length-1];
    }
}
/**
 *    1
 *   2 3
 *  4 5 6
 * 7 8 9 10
 */