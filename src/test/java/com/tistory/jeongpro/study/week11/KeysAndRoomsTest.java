package com.tistory.jeongpro.study.week11;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KeysAndRoomsTest {
    @Test
    public void 공식테스트() {
        KeysAndRooms keysAndRooms = new KeysAndRooms();
        boolean b = keysAndRooms.canVisitAllRooms(List.of(List.of(1, 3), List.of(3, 0, 1), List.of(2), List.of(0)));
        Assertions.assertThat(b).isFalse();
    }

    @Test
    public void 공식테스트2() {
        KeysAndRooms keysAndRooms = new KeysAndRooms();
        boolean b = keysAndRooms.canVisitAllRooms(List.of(List.of(1), List.of(2), List.of(3)));
        Assertions.assertThat(b).isTrue();
    }
}