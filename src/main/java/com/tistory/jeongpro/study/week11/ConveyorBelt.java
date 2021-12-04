package com.tistory.jeongpro.study.week11;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 컨베이어 벨트 위 로봇
 */
public class ConveyorBelt {
    private static int[] conveyorBelt;
    private static int upIdx;
    private static int downIdx;
    private static int durability;
    private static Queue<Integer> currRobotIndexQueue;

    public static int solution(int[] belts, int k) {
        conveyorBelt = belts;
        currRobotIndexQueue = new ArrayDeque<>();
        upIdx = 0;
        downIdx = (conveyorBelt.length / 2) - 1;
        durability = 0;
        int currStep = 0;
        while (true) {
            currStep++; // 스텝 하나 증가
            // 1. 벨트 이동 = 올리는 위치와 내리는 위치 인덱스 변경
            moveBelt();
            removeRobot();
            // 2. 올려진 로봇 순서대로 앞으로 한 칸씩 전진하되 앞에 로봇이 있다든가 앞칸에 내구도가 0이라면 움직이지 않는다.
            moveRobot();
            removeRobot();
            // 3. 올리는 위치에 내구도가 0보다 크면 로봇을 올린다.
            putRobot();
            // 4. 내구도가 0인 칸의 수가 K개 이상이면 단계를 멈춘다.
            if (durability >= k) {
                break;
            }
        }
        return currStep;
    }

    private static void putRobot() {
        if (conveyorBelt[upIdx] != 0) {
            conveyorBelt[upIdx] -= 1;
            currRobotIndexQueue.add(upIdx);
            if (conveyorBelt[upIdx] == 0) {
                durability++;
            }
        }
    }

    private static void removeRobot() {
        if (!currRobotIndexQueue.isEmpty() && currRobotIndexQueue.peek() == downIdx) {
            // 제일 먼저 올린 로봇이 제일 앞에 있을 거라서 내리는 위치에 오면 바로 내림
            currRobotIndexQueue.poll();
        }
    }

    private static void moveRobot() {
        if (currRobotIndexQueue.isEmpty()) {
            return;
        }
        int size = currRobotIndexQueue.size();
        for (int i = 0; i < size; i++) {
            Integer robotIndex = currRobotIndexQueue.poll();
            int nextIdx = (robotIndex + 1) == conveyorBelt.length ? 0 : robotIndex + 1;
            // 다음칸의 내구도가 0이면 움직이지 않음
            if (conveyorBelt[nextIdx] == 0) {
                currRobotIndexQueue.add(robotIndex);
                continue;
            }
            // 다음칸에 로봇이 있으면 그대로
            if (currRobotIndexQueue.contains(nextIdx)) {
                currRobotIndexQueue.add(robotIndex);
                continue;
            }
            // 내구도도 있고 로봇도 없으면 앞으로 한 칸 가고 내구도 깎고
            currRobotIndexQueue.add(nextIdx);
            conveyorBelt[nextIdx] -= 1;
            if (conveyorBelt[nextIdx] == 0) {
                durability++;
            }
        }
    }

    private static void moveBelt() {
        upIdx--;
        downIdx--;
        if (upIdx < 0) {
            upIdx = conveyorBelt.length - 1;
        }
        if (downIdx < 0) {
            downIdx = conveyorBelt.length - 1;
        }
    }
}
