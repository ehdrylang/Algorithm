package com.tistory.jeongpro.study.week9;

import java.util.ArrayList;
import java.util.List;

/**
 * target을 만들 수 있는 세가지 수의 조합 찾기
 * 중복없는 수가 주어질 거고
 * 여러번 사용해도 되고
 *
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result  = new ArrayList<>();
        // 특이 케이스 처리
        if (candidates == null || candidates.length == 0 || target <= 0) {
            return result;
        }
        recursive(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }
    private void recursive(int[] candidates, int start, int target, List<Integer> tempList, List<List<Integer>> result) {
        // 목표하는 값을 찾았으면 재귀 종료
        if (target == 0) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) {
                continue;
            }
            tempList.add(candidates[i]); // 선택
            recursive(candidates, i, target - candidates[i], tempList, result);
            tempList.remove(tempList.size() - 1); // 선택한거 다시 빼줌
        }
    }
}
