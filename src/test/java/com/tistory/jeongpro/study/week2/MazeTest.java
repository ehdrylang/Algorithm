package com.tistory.jeongpro.study.week2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MazeTest {
    @Test
    public void 공식_테스트() {
        int result = Maze.solution(5, 6, new int[][]{
                {1,0,1,0,1,1},
                {1,0,0,0,0,1},
                {0,0,1,1,0,1},
                {0,1,1,1,0,0},
                {0,0,0,0,0,0}
        });
        Assertions.assertThat(result).isEqualTo(8);
    }

}