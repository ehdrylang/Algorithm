package com.tistory.jeongpro.study.week7;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DuplicatedNumberTest {
    @Test
    public void 공식테스트() {
        int duplicate = DuplicatedNumber.findDuplicate(new int[]{1, 3, 4, 2, 2});
        Assertions.assertThat(duplicate).isEqualTo(2);
    }

}