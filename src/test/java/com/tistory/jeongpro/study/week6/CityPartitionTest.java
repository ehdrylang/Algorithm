package com.tistory.jeongpro.study.week6;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CityPartitionTest {
    @Test
    public void 공식테스트() {
        List<CityPartition.Node> nodes = new ArrayList<>();
        nodes.add(new CityPartition.Node(1,2,3));
        nodes.add(new CityPartition.Node(1,3,2));
        nodes.add(new CityPartition.Node(3,2,1));
        nodes.add(new CityPartition.Node(2,5,2));
        nodes.add(new CityPartition.Node(3,4,4));
        nodes.add(new CityPartition.Node(7,3,6));
        nodes.add(new CityPartition.Node(5,1,5));
        nodes.add(new CityPartition.Node(1,6,2));
        nodes.add(new CityPartition.Node(6,4,1));
        nodes.add(new CityPartition.Node(6,5,3));
        nodes.add(new CityPartition.Node(4,5,3));
        nodes.add(new CityPartition.Node(6,7,4));
        int result = CityPartition.solution(7, nodes);
        Assertions.assertThat(result).isEqualTo(8);
    }

}