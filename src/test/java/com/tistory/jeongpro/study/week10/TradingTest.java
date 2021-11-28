package com.tistory.jeongpro.study.week10;

import org.apache.logging.log4j.spi.Terminable;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TradingTest {
    @Test
    public void 공식테스트() {
        int solution = Trading.solution("436659", 2);
        Assertions.assertThat(solution).isEqualTo(966354);
    }

}