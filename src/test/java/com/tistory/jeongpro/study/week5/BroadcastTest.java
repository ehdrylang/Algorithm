package com.tistory.jeongpro.study.week5;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BroadcastTest {
    @Test
    public void 공식테스트() {
        int[][] input = new int[4][4];
        for(int i=1;i<input.length;i++) {
            for(int j=1;j<input.length;j++) {
                input[i][j] = Integer.MAX_VALUE / 2;
            }
        }
        input[1][2] = 4;
        input[1][3] = 2;
        Map.Entry<Integer, Integer> solution = Broadcast.solution(3, 2, 1, input);
        Assertions.assertThat(solution.getKey()).isEqualTo(2);
        Assertions.assertThat(solution.getValue()).isEqualTo(4);

    }

}