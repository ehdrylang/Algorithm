package com.tistory.jeongpro.study.week2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

/**
 * 미로 탈출
 * 최단거리로 괴물(벽) 피해서 출구 도착
 */
public class Maze {
    private static int N;
    private static int M;
    private static boolean[][] visited;

    public static int solution(int n, int m, int[][] maze) {
        N = n-1;
        M = m-1;
        int result = 0;
        List<Map.Entry<Integer, Integer>> lists = new ArrayList<>();
        lists.add(new AbstractMap.SimpleEntry<>(1, 0));
        lists.add(new AbstractMap.SimpleEntry<>(0, -1));
        lists.add(new AbstractMap.SimpleEntry<>(-1, 0));
        lists.add(new AbstractMap.SimpleEntry<>(0, 1));
        visited = new boolean[n][m];
        Queue<Node> queue = new ArrayDeque<>();
        Node firstNode = new Node(1, 1, 1);
        queue.add(firstNode);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (!isValid(node.getX(), node.getY())) {
                continue;
            }
            if (isVisited(node.getX(), node.getY())) {
                continue;
            }
            if (maze[node.getX()][node.getY()] == 1) {
                continue;
            }
            visited[node.getX()][node.getY()] = true;
            System.out.println("x : " + node.getX() + ", y : " + node.getY());
            if (node.getX() == N && node.getY() == M) {
                result = node.getCount();
                break;
            }
            lists.forEach(entry -> {
                int x = node.getX() + entry.getKey();
                int y = node.getY() + entry.getValue();
                queue.add(new Node(x, y, node.getCount() + 1));
            });
        }
        return result;
    }

    private static boolean isVisited(int x, int y) {
        return visited[x][y];
    }

    private static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    static class Node {
        int x;
        int y;
        int count;
    }
}
