package com.tistory.jeongpro.study.week6;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.PriorityQueue;

/**
 * 도시 분할 계획
 */
public class CityPartition {

    private static PriorityQueue<Node> priorityQueue;
    private static int[] houses;

    public static int solution(int n, List<Node> nodes) {
        houses = new int[n + 1];
        for (int i = 0; i < houses.length; i++) {
            houses[i] = i;
        }
        priorityQueue = new PriorityQueue<>();
        // 비용이 낮은 것부터 연결하는 식
        for (Node node : nodes) {
            priorityQueue.offer(node);
        }
        int sum = 0;
        int max = Integer.MIN_VALUE;
        while (!priorityQueue.isEmpty()) {
            Node node = priorityQueue.poll();
            int start = node.getStart();
            int end = node.getEnd();
            int parent1 = findParent(start);
            int parent2 = findParent(end);
            if (parent1 != parent2) {
                unionParent(start, end);
                sum += node.cost;
                if(max < node.cost) {
                    max = node.cost;
                }
            }
        }
        return sum - max;
    }
    public static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a < b) houses[b] = a;
        else houses[a] = b;
    }
    public static int findParent(int x) {
        if (x == houses[x]) {
            return x;
        }
        return houses[x] = findParent(houses[x]);
    }


    @AllArgsConstructor
    @Getter
    static class Node implements Comparable<Node> {
        private int start;
        private int end;
        private int cost;

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
