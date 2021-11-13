package com.tistory.jeongpro.study.week8;

import java.util.Stack;

/**
 * 빌드 보이는 최대 개수
 */
public class Building {
    private static double[] buildings;

    public static int solution(double[] buildingHeights) {
        buildings = buildingHeights;
        int result = 0;
        for (int i = 0; i < buildings.length; i++) {
            result = Math.max(result, solve(i));
        }
        return result;
    }

    public static int solve(int pos) {
        Stack<Double> stack = new Stack<>();
        //기준점 좌측
        for (int i = pos - 1; i >= 0; --i) {
            double slope = (buildings[pos] - buildings[i]) / (pos - i);
            if (i == pos - 1 || stack.peek() > slope) {
                stack.push(slope);
            }
        }

        //기준점 우측
        for (int i = pos + 1; i < buildings.length; ++i) {
            double slope = (buildings[i] - buildings[pos]) / (i - pos);
            if (i == pos + 1 || stack.peek() < slope) {
                stack.push(slope);
            }
        }
        return stack.size();
    }

}
