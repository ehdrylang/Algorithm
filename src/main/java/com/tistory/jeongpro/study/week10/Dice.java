package com.tistory.jeongpro.study.week10;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 주사위 굴리기
 */
public class Dice {

    private static int[] dice;
    private static List<Map.Entry<Integer, Integer>> directs;

    static {
        directs = new ArrayList<>();
        directs.add(new AbstractMap.SimpleEntry<>(0, 1)); // 동
        directs.add(new AbstractMap.SimpleEntry<>(0, -1)); // 서
        directs.add(new AbstractMap.SimpleEntry<>(-1, 0)); // 북
        directs.add(new AbstractMap.SimpleEntry<>(1, 0)); // 남
        dice = new int[7]; // 0은 버리고 동,서,북,남,위,아래
    }

    public static List<Integer> solution(List<Integer> commands, int[][] area, int x, int y) {
        List<Integer> result = new ArrayList<>();
        // 주사위는 0으로 초기화된 상태
        int currentX = x;
        int currentY = y;
        for (int i = 0; i < commands.size(); i++) {
            int command = commands.get(i);
            Map.Entry<Integer, Integer> direct = directs.get(command - 1);
            int nextX = currentX + direct.getKey();
            int nextY = currentY + direct.getValue();
            // 좌표가 유효하지 않으면 무시
            if(!isValid(nextX, nextY, area)) {
                continue;
            }
            action(command);
            if(area[nextX][nextY] == 0) {
                area[nextX][nextY] = dice[6];
            } else {
                dice[6] = area[nextX][nextY];
                area[nextX][nextY] = 0;
            }
            result.add(dice[5]);
            currentX = nextX;
            currentY = nextY;
        }
        return result;
    }

    // 동 서 북 남 위 아래
    public static void action(int d) {
        int[] temp = dice.clone();
        switch (d) {
            case 1: // 동 -> 북 남 이 그대로
                dice[1] = temp[5];
                dice[2] = temp[6];
//                dice[3] = temp[3];
//                dice[4] = temp[4];
                dice[5] = temp[2];
                dice[6] = temp[1];
                break;
            case 2: // 서 -> 북 남 이 그대로
                dice[1] = temp[6];
                dice[2] = temp[5];
//                dice[3] = temp[3];
//                dice[4] = temp[4];
                dice[5] = temp[1];
                dice[6] = temp[2];
                break;
            case 3: // 북 -> 동 서 가 그대로
                dice[3] = temp[5];
                dice[4] = temp[6];
                dice[5] = temp[4];
                dice[6] = temp[3];
                break;
            case 4: // 남 -> 동 서가 그대로
                dice[3] = temp[6];
                dice[4] = temp[5];
                dice[5] = temp[3];
                dice[6] = temp[4];
                break;
        }
    }

    private static boolean isValid(int x, int y, int[][] area) {
        return x >= 0 && x <= area.length - 1 && y >= 0 && y <= area[0].length - 1;
    }
}
