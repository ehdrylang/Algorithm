package com.tistory.jeongpro.study.week9;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MagicSquareTest {
    @Test
    public void 공식테스트() {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(5,3,4));
        list.add(Arrays.asList(1,5,8));
        list.add(Arrays.asList(6,4,2));

        int result = MagicSquare.formingMagicSquare(list);
        Assertions.assertThat(result).isEqualTo(7);

    }

}