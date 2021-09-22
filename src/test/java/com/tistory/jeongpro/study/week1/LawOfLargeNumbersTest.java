package com.tistory.jeongpro.study.week1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LawOfLargeNumbersTest {
    @Test
    public void 공식_테스트케이스() {
        int sum = LawOfLargeNumbers.test(5, 8, 3, new int[]{2, 4, 5, 4, 6});
        Assertions.assertThat(sum).isEqualTo(46);
    }

    @Test
    public void M보다_K가_클때는_큰수만_골라야한다() {
        int sum = LawOfLargeNumbers.test(5, 5, 7, new int[]{2, 4, 5, 4, 6});
        Assertions.assertThat(sum).isEqualTo(30);
    }

    @Test
    public void 가장큰수와_그다음큰수가_같을때는_큰수만_고른것과_같다() {
        int sum = LawOfLargeNumbers.test(5, 5, 7, new int[]{2, 4, 6, 4, 6});
        Assertions.assertThat(sum).isEqualTo(30);
    }
}