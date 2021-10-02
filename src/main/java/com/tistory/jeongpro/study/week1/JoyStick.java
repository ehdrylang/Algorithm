package com.tistory.jeongpro.study.week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JoyStick {
    public int test(String name) {
        int result = 0;
        Boolean[] notA = new Boolean[name.length()];
        for (int i = 0; i < name.length(); i++) {
            notA[i] = name.charAt(i) != 'A';
        }
        int currIdx = 0;
        while (isFinished(notA)) {
            if (notA[currIdx]) {
                int moved = searchMinMove(name.charAt(currIdx));
                result += moved;
                notA[currIdx] = false;
            }
            List<Integer> integers = searchMinIndex(notA, currIdx);
            currIdx = integers.get(0);
            result += integers.get(1);
        }

        return result;
    }

    private boolean isFinished(Boolean[] notA) {
        return Arrays.stream(notA).noneMatch(b -> b);
    }

    private int searchMinMove(char c) {
        int up = c - 'A';
        int down = 'Z' - c + 1;
        return Math.min(up, down);
    }

    private List<Integer> searchMinIndex(Boolean[] notA, int currIdx) {
        List<Integer> result = new ArrayList<>();
        int left = currIdx;
        int leftCount = 0;
        int right = currIdx;
        int rightCount = 0;
        while (true) {
            left--;
            leftCount++;
            if (left < 0) {
                left = notA.length - 1;
            }
            if (notA[left]) {
                break;
            }
        }
        while (true) {
            right++;
            rightCount++;
            if (right > notA.length - 1) {
                right = 0;
            }
            if (notA[right]) {
                break;
            }
        }
        if (leftCount >= rightCount) {
            result.add(right);
            result.add(rightCount);
        } else {
            result.add(left);
            result.add(leftCount);
        }
        return result;
    }

}
