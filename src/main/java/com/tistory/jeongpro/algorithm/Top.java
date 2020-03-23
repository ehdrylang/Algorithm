package com.tistory.jeongpro.algorithm;

import java.util.Stack;

/**
 * 프로그래머스 '탑' 문제
 * 송수신하는 탑
 */
public class Top {
    public int[] solution(int[] heights) {
        int[] answer = new int[heights.length];

        for(int i=heights.length-1; i>0; i--) {
            for(int j=i-1; j>=0; j--) {
                if(heights[i] < heights[j]) {
                    answer[i] = j+1;
                    break;
                }
            }
        }
        answer[0] = 0;

        return answer;
    }
}
