package com.tistory.jeongpro.study.week7;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SafeArea {
    private static int[][] area;
    private static boolean[][] visited;
    private static List<Map.Entry<Integer, Integer>> actions;
    private static int h;
    static {
        actions = new ArrayList<>();
        actions.add(new AbstractMap.SimpleEntry<>(0, 1));
        actions.add(new AbstractMap.SimpleEntry<>(1, 0));
        actions.add(new AbstractMap.SimpleEntry<>(0, -1));
        actions.add(new AbstractMap.SimpleEntry<>(-1, 0));
    }

    public static int solution(int[][] arrays) {
        area = arrays;
        h = area.length; //물에 잠기는 높이
        visited = new boolean[h][h];
        int safeAreaCount = 0;
        for (int i = 0; i < area.length; i++) {
            for (int j = 0; j < area[i].length; j++) {
                if(area[i][j] > h && !visited[i][j]) {
                    safeAreaCount++;
                }
                visit(i,j);
            }
        }
        return safeAreaCount;
    }

    private static void visit(int x, int y) {
        // 유효한 범위가 아니거나 이미 방문했으면 종료
        if (!isValid(x, y) || visited[x][y]) {
            return;
        }
        if (area[x][y] <= h) {
            return;
        }
        visited[x][y] = true;
        actions.forEach(entry -> visit(x + entry.getKey(), y + entry.getValue()));
    }

    private static boolean isValid(int x, int y) {
        return x >= 0 && x < area.length && y >= 0 && y < area.length;
    }
}
