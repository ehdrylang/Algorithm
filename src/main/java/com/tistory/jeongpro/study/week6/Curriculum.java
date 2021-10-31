package com.tistory.jeongpro.study.week6;

import java.util.*;

/**
 * 커리큘럼
 * 선수과목이 있는 강의를 모두 들을 때 필요한 최소 시간 구하기
 */
public class Curriculum {
    private static Queue<Integer> queue;

    public static List<Integer> solution(Map<Integer, List<Integer>> lessonMap, List<Integer> times) {
        queue = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        times.forEach(time -> result.add(time));
        int[] indegree = new int[lessonMap.size() + 1];
        // 선수과목이 없는 과목부터 처리 = 진입차수가 0인 것 = 진입차수 구하기
        for (Map.Entry<Integer, List<Integer>> lesson : lessonMap.entrySet()) {
            List<Integer> value = lesson.getValue();
            if (value == null || value.size() == 0) {
                continue;
            }
            value.forEach(x -> indegree[x]++);
        }
        // 진입차수가 0인 과목을 시작점으로 잡음
        for (int i = 1; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        // 큐가 빌 때까지 반복
        while (!queue.isEmpty()) {
            int value = queue.poll();
            // value로 시작하는 진입차수 하나씩 빼주기
            List<Integer> next = lessonMap.get(value);
            if (next == null || next.size() == 0) {
                continue;
            }
            for (Integer integer : next) {
                result.set(integer, Math.max(result.get(integer), result.get(value) + result.get(integer)));
                indegree[integer]--;
                if(indegree[integer] == 0) {
                    queue.offer(integer);
                }
            }
        }
        return result;
    }
}
