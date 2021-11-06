package com.tistory.jeongpro.study.week7;

import java.util.Arrays;

/**
 * 중복되는 숫자가 한 번만 있는 줄 알았음. 문제 잘못 이해
 */
public class DuplicatedNumber {
    public static int findDuplicate(int[] nums) {
//        //1 ~ N+1 까지 더한 수
//        int length = nums.length * (nums.length + 1) / 2;
//        // 중복으로 나온 수수
//        int sum = Arrays.stream(nums).sum();
//        return nums.length - (length - sum);

        // 해당 위치를 탐색한 적 있는지를 음수로 처리할 예정
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]);
            // 이미 음수로 변해져있다면 결과 리턴
            if(nums[index] < 0) {
                return index;
            }
            nums[index] = -nums[index];
        }
        return -1;
    }
}

