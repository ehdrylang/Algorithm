package com.tistory.jeongpro.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 프로그래머스 체육복
 */
public class TrainingClothes {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] count = new int[n+1];
        for(int i = 1 ; i <= n ; i++) {
            count[i] = 1;
        }

        for(int i = 0 ; i<lost.length ; i++) {
            count[lost[i]] = 0;
        }

        for(int i = 0 ; i < reserve.length ; i++) {
            count[reserve[i]]++;
        }

        for(int i = 0 ; i < lost.length ; i++) {
            if(count[lost[i]] == 0) {
                if( lost[i] - 1 >= 1 && count[lost[i] - 1] == 2) {
                    count[lost[i]] = 1;
                    count[lost[i] - 1]--;
                }else if(lost[i] + 1 <= n && count[lost[i] + 1] == 2) {
                    count[lost[i]] = 1;
                    count[lost[i] + 1]--;
                }
            }
        }

        int ans = 0;
        for(int i = 1 ; i <= n ; i++) {
            if(count[i] != 0)
                ans++;
        }

        return ans;
    }
}
