package com.tistory.jeongpro.study.week4;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ToOneTest {
    @Test
    public void 공식테스트(){
        int result = ToOne.solution(26);
        Assertions.assertThat(result).isEqualTo(3);
    }
}
