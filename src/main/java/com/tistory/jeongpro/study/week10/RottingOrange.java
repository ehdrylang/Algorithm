package com.tistory.jeongpro.study.week10;

import java.util.*;

public class RottingOrange {
    private static List<Map.Entry<Integer, Integer>> directs;
    private static Queue<Map.Entry<Integer, Integer>> queue;

    static {
        directs = new ArrayList<>();
        directs.add(new AbstractMap.SimpleEntry<>(-1, 0));
        directs.add(new AbstractMap.SimpleEntry<>(1, 0));
        directs.add(new AbstractMap.SimpleEntry<>(0, 1));
        directs.add(new AbstractMap.SimpleEntry<>(0, -1));
        queue = new ArrayDeque<>();
    }

    public int orangesRotting(int[][] grid) {
        int result = 0;
        //썩은 오렌지를 큐에 넣는다.
        boolean existFreshOrange = false;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new AbstractMap.SimpleEntry<>(i, j));
                }
                if (grid[i][j] == 1) {
                    existFreshOrange = true;
                }
            }
        }
        // 신선한 오렌지가 없으면 -1 리턴
        if (!existFreshOrange) {
            return -1;
        }

        while (!queue.isEmpty()) {
            result++;
            int currentQueueSize = queue.size();
            while (currentQueueSize != 0) {
                Map.Entry<Integer, Integer> currentPoint = queue.poll();
                int currX = currentPoint.getKey();
                int currY = currentPoint.getValue();
                for (int i = 0; i < directs.size(); i++) {
                    Map.Entry<Integer, Integer> entry = directs.get(i);
                    int nextX = currX + entry.getKey();
                    int nextY = currY + entry.getValue();
                    if (!isValid(nextX, nextY, grid)) {
                        continue;
                    }
                    if (grid[nextX][nextY] == 1) {
                        grid[nextX][nextY] = 2; // 썩게 하자
                        queue.add(new AbstractMap.SimpleEntry<>(nextX, nextY));
                    }
                }
                currentQueueSize--;
            }
            if(!existFreshOrange(grid)) {
                break;
            }
        }
        return result;
    }

    private boolean existFreshOrange(int[][] area) {
        boolean existFreshOrange = false;
        for(int i=0;i< area.length;i++) {
            for(int j=0;j<area[i].length;j++) {
                if(area[i][j] == 1) {
                    existFreshOrange = true;
                }
            }
        }
        return existFreshOrange;
    }


    private boolean isValid(int x, int y, int[][] area) {
        return x >= 0 && x <= area[0].length - 1 && y >= 0 && y <= area.length - 1;
    }
}
