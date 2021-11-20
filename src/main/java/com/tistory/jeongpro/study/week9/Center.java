package com.tistory.jeongpro.study.week9;

import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.Queue;

/**
 * 연구소
 * 바이러스 퍼지는거 따로
 * 벽치기 따로
 * 최적의 해 구하기
 */
public class Center {
    private static int[][] map;
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {1, -1, 0, 0};
    private static int max_area = Integer.MIN_VALUE;
    public static int solution(int[][] matrix) {
        map = matrix;
        makeWall(0);
        return max_area;
    }
    public static void makeWall(int depth) {
        if (depth == 3) { // 벽이 3개가 채워졌다? 바이러스 살포해서 안전영역 확인
            BFS();
            return;
        }
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    makeWall(depth + 1);
                    map[i][j] = 0;
                }
            }
        }
    }
    public static void BFS() {
        int[][] virus_map = new int[map.length][map[0].length];

        // BFS를 위한 큐
        Queue<Map.Entry<Integer, Integer>> queue = new ArrayDeque<>();

        // 벽을 세운 뒤 상태 복사
        for (int i = 0; i < virus_map.length; i++) {
            for (int j = 0; j < virus_map[i].length; j++) {
                virus_map[i][j] = map[i][j];
            }
        }

        for (int i = 0; i < virus_map.length; i++) {
            for (int j = 0; j < virus_map[i].length; j++) {
                if (virus_map[i][j] == 2) {
                    queue.add(new AbstractMap.SimpleEntry<>(i, j)); // 퍼질 바이러스 넣기
                }
            }
        }

        while (!queue.isEmpty()) {
            Map.Entry<Integer, Integer> virus = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = virus.getKey() + dx[i];
                int nextY = virus.getValue() + dy[i];

                // 범위안에 있고, 해당 자리가 빈칸일 경우 바이러스로 변경
                if (isValid(nextX, nextY)) {
                    if (virus_map[nextX][nextY] == 0) {
                        virus_map[nextX][nextY] = 2;
                        queue.add(new AbstractMap.SimpleEntry<>(nextX, nextY));
                    }
                }
            }
        }

        int area = 0;

        // 안전지역 계산을 위한 반복문
        for (int i = 0; i < virus_map.length; i++) {
            for (int j = 0; j < virus_map[i].length; j++) {
                if (virus_map[i][j] == 0) {
                    area++;
                }
            }
        }

        // 둘 중 더 큰 값을 result에 저장한다.
        max_area = Math.max(area, max_area);

    }

    public static boolean isValid(int x, int y) {
        if (x >= 0 && y >= 0 && x < map.length && y < map[0].length) {
            return true;
        }
        return false;
    }
}
