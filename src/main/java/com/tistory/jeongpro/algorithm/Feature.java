package com.tistory.jeongpro.algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 프로그래머스 기능개발
 */
public class Feature {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        int begin = 0;
        int end = progresses.length;

        for(int time = 1; time<=100 ;time++){
            if(begin == end)
                break;

            for(int i=begin; i<end ;i++)
                progresses[i] += speeds[i];

            if(progresses[begin] >= 100){
                int cnt = 0;
                for(int i=begin; i<end; i++){
                    if(progresses[i]>=100)
                        cnt++;
                    else
                        break;
                }
                queue.add(cnt);
                begin += cnt;
            }
        }
        int idx = 0;
        int[] answer = new int[queue.size()];
        while(!queue.isEmpty()){

            answer[idx] = queue.poll();
            idx++;
        }
        return answer;
    }
}
