package com.tistory.jeongpro.study.week7;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ThreeSumTest {
    @Test
    public void 공식테스트() {
        List<List<Integer>> lists = ThreeSum.threeSum(new int[]{0, -1, -1, 1});
        Assertions.assertThat(lists.get(0)).containsSequence(-1,0,1);
    }
}