package com.tistory.jeongpro.study.week7;

import java.util.Arrays;

/**
 * 퇴사하기 직전에 영끌하는 경우 찾기
 * 생각1 메뚜기 식량 문제 생각나니까 메모이제이션 가자.
 * 못풀음
 */
public class Freedom {
    public static int solution(int[][] schedule) {
        int[] memoization = new int[schedule.length];
        
        if (schedule[schedule.length-1][0] == 1) {
            memoization[schedule.length-1] = schedule[schedule.length-1][1];
        }
        for (int i = schedule.length - 2; i >= 0; i--) {
            int duration = schedule[i][0];
            int income = schedule[i][1];
            if (i + duration > schedule.length) { //퇴사기간 때문에 일정 못 잡는 경우
                continue;
            }

            memoization[i] = Math.max(memoization[i + 1], memoization[i + duration] + income);
        }
        return Arrays.stream(memoization).max().orElse(0);
    }
}
