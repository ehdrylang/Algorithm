package com.tistory.jeongpro.study.week1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LawOfLargeNumbersTest {
    @Test
    public void 공식_테스트케이스(){
        int sum = LawOfLargeNumbers.test(5, 8, 3, new int[]{2, 4, 5, 4, 6});
        Assertions.assertThat(sum).isEqualTo(46);
    }
}