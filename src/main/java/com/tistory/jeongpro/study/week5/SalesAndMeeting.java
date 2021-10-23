package com.tistory.jeongpro.study.week5;

import ch.qos.logback.core.net.QueueFactory;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 방문 판매와 소개팅
 * n개의 회사가 각 숫자지점에 있다.
 * 1번 지점에서 K번 지점에 있는 사람과 소개팅 후, M번 지점 회사에 판매할 때 최단 시간구하기
 * 회사이동당 소요시간은 무조건 1
 * 1 -> k -> m
 * 도달 불가시 -1 리턴
 */
public class SalesAndMeeting {
    private static Queue<Integer> queue = new ArrayDeque();

    public static int solution(int n, List<Map.Entry<Integer, Integer>> list, int k, int x) {
        // a -> b로 가는 방법 2차원 배열로 만든다. matrix[a][b] 는 a->b로 갈 수 있고 비용은 1이다.
        int[][] matrix = new int[n+1][n+1];
        for(Map.Entry<Integer, Integer> entry : list) {
            matrix[entry.getKey()][entry.getValue()] = 1;
            matrix[entry.getValue()][entry.getKey()] = 1;
        }
        // 1 -> k 로 가는 최단 거리. 각 지점으로 가는 최소 비용 계산할꺼라 방문 여부 배열 생성
        boolean[] visited = new boolean[n+1];
        // 최소거리 구할꺼니까 시작점(1) 빼고 다 Integer.MAX_VALUE로 초기화
        int[] distance = new int[n+1];
        distance[1] = 0;
        for(int i=2;i<distance.length;i++) {
            distance[i] = Integer.MAX_VALUE / 2;
        }
        // 1번에서 K로 소개팅하러 가니까
        int start = 1;
        while(true) {
            visited[start] = true;
            for(int i=1;i<matrix.length;i++) {
                if (matrix[start][i] != 1) {
                    continue;
                }
                distance[i] = Math.min(distance[start] + matrix[start][i], distance[i]);
            }
            Map.Entry<Integer, Integer> next = next(visited, distance);
            if (next.getKey() == -1 || start == next.getKey()) {
                break;
            }
            start = next.getKey();
        }
        int oneToK = distance[k];
        if(oneToK == Integer.MAX_VALUE / 2) {
            return -1;
        }
        // k -> x
        // 초기화
        for(int i=1;i<distance.length;i++) {
            distance[i] = Integer.MAX_VALUE / 2;
            visited[i] = false;
        }
        start = k;
        distance[k] = 0;
        while(true) {
            visited[start] = true;
            for(int i=1;i<matrix.length;i++) {
                if (matrix[start][i] != 1) {
                    continue;
                }
                distance[i] = Math.min(distance[start] + matrix[start][i], distance[i]);
            }
            Map.Entry<Integer, Integer> next = next(visited, distance);
            if (next.getKey() == -1 || start == next.getKey()) {
                break;
            }
            start = next.getKey();
        }
        int kToX = distance[x];
        if(kToX == Integer.MAX_VALUE / 2) {
            return -1;
        }
        return oneToK + kToX;
    }
    private static Map.Entry<Integer, Integer> next(boolean[] visited, int[] distance) {
        int idx = -1;
        int min = Integer.MAX_VALUE;
        for(int i=1;i<distance.length;i++) {
            if(!visited[i] && min > distance[i]) {
                idx = i;
                min = distance[i];
            }
        }
        return new AbstractMap.SimpleEntry<>(idx, min);
    }
}
