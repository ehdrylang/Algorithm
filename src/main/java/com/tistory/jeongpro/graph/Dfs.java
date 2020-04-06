package com.tistory.jeongpro.graph;

public class Dfs {
    public static int count;//정점의 개수
    public static int start;//시작 정점
    public static int[][] array;//인접 노드 행렬
    public static boolean[] visit;//정점 방문 여부

    public static void dfsTest(){
        count = 10;//정점의 개수
        start = 1;//시작정점
        array = new int[count+1][count+1];//인접노드 행렬
        visit = new boolean[count+1];//정점 방문 여부

        //행렬 노드 연결 구조 생성 가정

    }
    public static void dfs(int start){
        visit[start] = true;//방문했다!
        for(int i=1;i<=count;i++){
            if(array[start][i] == 1 && visit[i] == false){
                System.out.println(start + "->" + i);
                dfs(i);
            }
        }
    }
}
