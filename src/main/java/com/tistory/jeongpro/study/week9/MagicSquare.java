package com.tistory.jeongpro.study.week9;

import java.util.List;

/**
 * 마방진이 뭔지도 몰랐는데...
 */
public class MagicSquare {
    public static int formingMagicSquare(List<List<Integer>> s) {
        // Write your code here
        int[][][] magicSquare = {{{8, 1, 6}, {3, 5, 7}, {4, 9, 2}}, {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}},
                {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}}, {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}},
                {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}}, {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}},
                {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}}, {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}}};
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < magicSquare.length; i++) {
            int cost = 0;
            for (int j = 0; j < s.size(); j++) {
                for (int k = 0; k < s.get(j).size(); k++) {
                    if (s.get(j).get(k) != magicSquare[i][j][k]) {
                        cost += Math.abs(s.get(j).get(k) - magicSquare[i][j][k]);
                    }
                }
            }
            result = Math.min(result, cost);
        }
        return result;
    }
}
