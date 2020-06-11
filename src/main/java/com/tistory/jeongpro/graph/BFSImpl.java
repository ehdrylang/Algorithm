package com.tistory.jeongpro.graph;

import com.tistory.jeongpro.leetcode.EasyTest;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * BFS를 공부하고 다시 구현할 수 있는지 연습하는 클래스
 */
@Component
public class BFSImpl {
    /**
     * 리트코드에서 가져온 노드
     */
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    @PostConstruct
    private void init(){
        Node n7 = new Node(7, null);
        Node n6 = new Node(6, null);
        Node n5 = new Node(5, null);
        Node n4 = new Node(4, null);
        Node n3 = new Node(3, Arrays.asList(n6,n7));
        Node n2 = new Node(2, Arrays.asList(n4,n5));
        Node n1 = new Node(1, Arrays.asList(n2,n3));
        BFS(n1);
    }
    public void BFS(Node node){
        //총 길이를 알아야겠네
        int size = totalNodeCount(node);
        boolean[] visited = new boolean[size+1];

    }
    private int totalNodeCount(Node node){
        if(node.children == null){
            return 1;
        }
        int sum = 1 + node.children.stream()
                                   .map(x-> totalNodeCount(x))
                                   .reduce(0, (acc, curr)->acc +curr);
        return sum;
    }
}
