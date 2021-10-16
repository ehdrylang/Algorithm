package com.tistory.jeongpro.study.week4;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TileTest {
    @Test
    public void 개수3() {
        int result = Tile.solution(3);
        Assertions.assertThat(result).isEqualTo(5);
    }
    @Test
    public void 개수4() {
        int result = Tile.solution(4);
        Assertions.assertThat(result).isEqualTo(11);
    }
    @Test
    public void 개수5() {
        int result = Tile.solution(5);
        Assertions.assertThat(result).isEqualTo(21);
    }

}