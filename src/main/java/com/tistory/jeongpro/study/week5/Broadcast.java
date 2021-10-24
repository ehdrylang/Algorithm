package com.tistory.jeongpro.study.week5;

import java.util.AbstractMap;
import java.util.Map;

/**
 * 어떤 지점에서 메시지를 보낼건데 최대한 많이 보낼 때
 * 보낸 도시 수와 걸린 최소 시간 계산
 */
public class Broadcast {
    public static Map.Entry<Integer, Integer> solution(int cityCount, int pipeCount, int startCity, int[][] pipes) {
        boolean[] visited = new boolean[cityCount + 1];
        int[] distance = new int[cityCount + 1];
        for (int i = 1; i < cityCount + 1; i++) {
            distance[i] = Integer.MAX_VALUE / 2;
        }
        distance[startCity] = 0;
        while (true) {
            visited[startCity] = true;
            for (int i = 1; i < cityCount + 1; i++) {
                distance[i] = Math.min(pipes[startCity][i] + distance[startCity], distance[i]);
            }
            Map.Entry<Integer, Integer> next = next(visited, distance);
            if (next.getKey() == -1 || startCity == next.getKey()) {
                break;
            }
            startCity = next.getKey();
        }
        // 메시지가 전달된 도시의 수
        int visitedCount = -1;
        for (int i = 1; i < cityCount + 1; i++) {
            if (visited[i]) {
                visitedCount++;
            }
        }
        // 메시지를 전달받은 도시중에 오래 걸린 시간
        int time = 0;
        for (int i = 1; i < cityCount + 1; i++) {
            if (distance[i] == Integer.MAX_VALUE / 2) {
                continue;
            }
            time = Math.max(time, distance[i]);
        }
        return new AbstractMap.SimpleEntry<>(visitedCount, time);
    }

    private static Map.Entry<Integer, Integer> next(boolean[] visited, int[] distance) {
        int idx = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < distance.length; i++) {
            if (!visited[i] && min > distance[i]) {
                idx = i;
                min = distance[i];
            }
        }
        return new AbstractMap.SimpleEntry<>(idx, min);
    }
}
