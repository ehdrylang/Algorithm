package com.tistory.jeongpro.study.week7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 생각했던 것
 * - 일단 조합(?)으로 2개의 정수를 뽑고 나머지 하나를 더했을 때 0이 되는지?
 * - 정렬해야겠다는 생각을 못 했음.
 */
public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // 계산 대상이 아니므로 빈 리스트 리턴
        if (nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int pick1 = nums[i];//1번 픽
            // 중복제거 -> 이전이랑 같은 숫자라면 한 번 더 돌 필요가 없음
            if (i > 0 && pick1 == nums[i - 1]) {
                continue;
            }
            int j = i + 1; //2번 픽 인덱스
            int k = nums.length - 1; //3번 픽 인덱스
            while (j < k) {
                int pick2 = nums[j];
                int pick3 = nums[k];
                int sum = pick1 + pick2 + pick3;
                if (sum > 0) {
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    result.add(Arrays.asList(pick1, pick2, pick3));
                    j++;
                    k--;
                    while(j<k && pick2 == nums[j]) {
                        j++;
                    }
                    while(j<k && pick3 == nums[k]) {
                        k--;
                    }
                }
            }
        }
        return result;
    }
}
