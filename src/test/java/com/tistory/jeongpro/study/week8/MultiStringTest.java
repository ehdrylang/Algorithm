package com.tistory.jeongpro.study.week8;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultiStringTest {
    @Test
    public void 공식테스트() {
        MultiString ms = new MultiString();
        String multiply = ms.multiply("123", "456");
        Assertions.assertThat(multiply).isEqualTo("56088");
    }
}