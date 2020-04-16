package com.tistory.jeongpro.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class Bfs {
    public static void bfs(){
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        g.BFS(2);
    }
    public static class Graph {
        private int V; // 노드의 개수
        private LinkedList<Integer> adj[]; // 인접 리스트

        /** 생성자 */
        Graph(int v) {
            V = v;
            adj = new LinkedList[v];
            for (int i=0; i<v; ++i) // 인접 리스트 초기화
                adj[i] = new LinkedList();
        }

        /** 노드를 연결 v->w */
        void addEdge(int v, int w) { adj[v].add(w); }

        /** s를 시작 노드으로 한 BFS로 탐색하면서 탐색한 노드들을 출력 */
        void BFS(int s) {
            // 노드의 방문 여부 판단 (초깃값: false)
            boolean visited[] = new boolean[V];
            // BFS 구현을 위한 큐(Queue) 생성
            LinkedList<Integer> queue = new LinkedList<Integer>();

            // 현재 노드를 방문한 것으로 표시하고 큐에 삽입(enqueue)
            visited[s] = true;
            queue.add(s);

            // 큐(Queue)가 빌 때까지 반복
            while (queue.size() != 0) {
                // 방문한 노드를 큐에서 추출(dequeue)하고 값을 출력
                s = queue.poll();
                System.out.print(s + " ");

                // 방문한 노드와 인접한 모든 노드를 가져온다.
                Iterator<Integer> i = adj[s].listIterator();
                while (i.hasNext()) {
                    int n = i.next();
                    // 방문하지 않은 노드면 방문한 것으로 표시하고 큐에 삽입(enqueue)
                    if (!visited[n]) {
                        visited[n] = true;
                        queue.add(n);
                    }
                }
            }
        }
    }
}
