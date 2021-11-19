package com.tistory.jeongpro.study.week9;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.TestPropertySource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CombinationSumTest {
    @Test
    public void 공식테스트() {
        CombinationSum combinationSum = new CombinationSum();
        List<List<Integer>> lists = combinationSum.combinationSum(new int[]{2, 3, 6, 7}, 7);
        Assertions.assertThat(lists).containsSequence(Arrays.asList(2,2,3), Arrays.asList(7));
        Assertions.assertThat(lists).hasSize(2);
    }

}