package com.tistory.jeongpro.study.week2;

import java.util.*;

/**
 * 게임 개발
 *
 * @direction : 0=북, 1=동, 2=남, 3=서
 */
public class GameDevelopment {

    public static int solution(boolean[][] area, int x, int y, int d) {
        int currX = x;
        int currY = y;
        int currD = d;

        // 방문한 곳 카운트
        Set<String> visited = new HashSet<>();
        visited.add(new StringBuilder().append(x).append(y).toString());

        // 방향에 따른 이동 방법 정의
        List<Map.Entry<Integer, Integer>> actions = new ArrayList<>();
        actions.add(new AbstractMap.SimpleEntry<>(0, 1));
        actions.add(new AbstractMap.SimpleEntry<>(1, 0));
        actions.add(new AbstractMap.SimpleEntry<>(0, -1));
        actions.add(new AbstractMap.SimpleEntry<>(-1, 0));

        int failCount = 0;
        while (true) {
            currD = changeDirection(currD); // 90도 반시계 방향 회전

            Map.Entry<Integer, Integer> entry = actions.get(currD); // 방향에 따른 진행 방법

            int nextX = currX + entry.getKey();
            int nextY = currY + entry.getValue();

            String hash = new StringBuilder().append(nextX).append(nextY).toString();//방문 여부 해시 값

            if (!isValid(nextX, nextY, area) || isItSea(nextX, nextY, area) || visited.contains(hash)) {
                failCount++;
                if (failCount == 4) {
                    int backDirection = changeBackDirection(currD);
                    Map.Entry<Integer, Integer> entry2 = actions.get(backDirection);
                    int backX = currX + entry2.getKey();
                    int backY = currY + entry2.getValue();
                    if (isItSea(backX, backY, area)) {
                        break;
                    }
                    currX = backX;
                    currY = backY;
                }
                continue;
            }
            visited.add(hash);
            currX = nextX;
            currY = nextY;
            failCount = 0;
        }
        return visited.size();
    }

    private static int changeDirection(int d) {
        return d - 1 < 0 ? 3 : d - 1;
    }

    private static int changeBackDirection(int d) {
        return d - 2 < 0 ? d + 2 : d - 2;
    }

    private static boolean isValid(int x, int y, boolean[][] area) {
        return x >= 0 && x <= area[0].length - 1 && y >= 0 && y <= area.length - 1;
    }
    private static boolean isItSea(int x, int y, boolean[][] area) {
        return area[x][y];
    }
}
