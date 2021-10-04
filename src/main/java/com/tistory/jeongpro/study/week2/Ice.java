package com.tistory.jeongpro.study.week2;

/**
 * 얼음 얼려 먹기
 * 얼음 덩어리 단위 개수 세기
 * 00
 * 00
 * 00
 * 00
 */
public class Ice {
    public static int solution(int n, int m, int[][] iceBlocks) {
        int result = 0;

        int[][] visited = new int[n][m];

        for (int i = 0; i < iceBlocks.length; i++) {
            for (int j = 0; j < iceBlocks[i].length; j++) {
                if (iceBlocks[i][j] == 0) { // 빈칸?
                    if (visited[i][j] == 0) { //이미 채운적이 없으면
                        result++; //새로 채우니까 +1
                        visited[i][j] = result; // 채운 곳이라고 체크
                    }
                    int k = i + 1; // 오른쪽 다음칸
                    if (k < n && iceBlocks[k][j] == 0) {
                        visited[k][j] = result;
                    }
                    int l = j + 1; // 아래쪽 다음칸
                    if (l < m && iceBlocks[i][l] == 0) {
                        visited[i][l] = result;
                    }
                }
            }
        }

        return result;
    }
}
