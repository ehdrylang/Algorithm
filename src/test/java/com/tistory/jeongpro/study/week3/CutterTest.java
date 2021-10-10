package com.tistory.jeongpro.study.week3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CutterTest {
    @Test
    public void 공식테스트(){
        int solution = Cutter.solution(new ArrayList<Integer>(Arrays.asList(19, 15, 10, 17)), 6);
        Assertions.assertThat(solution).isEqualTo(15);
    }
}