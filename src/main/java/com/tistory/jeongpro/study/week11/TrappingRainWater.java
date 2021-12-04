package com.tistory.jeongpro.study.week11;

import java.util.*;

/**
 * 빗물 채우기
 * 높이 배열이 주어지고 사이에 빗물을 채웠을 때 얼마나 많이 채울 수 있는지?
 * - 아이디어 1
 * 앞에서 부터 뒤로 가면서 낮은게 있나 확인하고 있으면 다시 높은게 있나 확인해서 물 붓기
 * - 아이디어 2
 * 최대값을 찾은 다음에 양쪽 편으로 물을 담자
 */
public class TrappingRainWater {
    public int trap(int[] height) {
//        Stack<Map.Entry<Integer, Integer>> stack = new Stack<>();
//        Stack<Map.Entry<Integer, Integer>> stackUp = new Stack<>();
//        for (int i = 0; i < height.length; i++) {
//            int h = height[i];
//            if (!stack.isEmpty() && stack.peek().getValue() > h) { // 높이가 커지는 순간 계산하겠다!
//                stackUp.push(new AbstractMap.SimpleEntry<>(i, h));
//                for (int j = i+1; j < height.length; j++) {
//                    if(!stackUp.isEmpty() && stack.peek().getValue() < height[j]) {
//                        // 계산
//                    }
//                    stackUp.push(new AbstractMap.SimpleEntry<>(j, h));
//                }
//            }
//            stack.push(new AbstractMap.SimpleEntry<>(i, h));
//        }
        int maxIndex = 0;
        // 기준이 되는 벽의 위치를 잡아버린다. = 최대값이 벽
        for (int i = 0; i < height.length; i++) {
            if (height[maxIndex] < height[i]) {
                maxIndex = i;
            }
        }
        int sum = 0;
        int max = 0;
        // 벽의 왼쪽 부분을 탐색하며 기둥이 낮아질때마다 물을 채운다!
        for (int i = 0; i < maxIndex; i++) {
            if (max < height[i]) {
                max = height[i];
            } else if (max > height[i]) {
                sum += (max - height[i]);
            }
        }
        max = 0;
        // 벽의 오른쪽 부분을 탐색하며 기둥이 낮아질때마다 물을 채운다!
        for (int i = height.length - 1; i > maxIndex; i--) {
            if (max < height[i]) {
                max = height[i];
            } else if (max > height[i]) {
                sum += (max - height[i]);
            }
        }
        return sum;
    }
}
