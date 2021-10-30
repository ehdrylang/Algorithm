package com.tistory.jeongpro.study.week6;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

/**
 * 팀 결성
 */
public class TeamMatching {
    private static int[] users;
    public static List<String> solution(int n, List<Entry<Integer, Entry<Integer, Integer>>> commands) {
        //0~n명 배열 생성
        users = new int[n + 1];
        // 원소 값을 팀으로 처리할거라서 일단 각기 다른팀이니 자기 번호 씀
        for (int i = 0; i < users.length; i++) {
            users[i] = i;
        }
        List<String> result = new ArrayList<>();
        for(Entry<Integer, Entry<Integer, Integer>> command : commands) {
            Integer key = command.getKey();
            if (key == 0) { //합치기
                Entry<Integer, Integer> target = command.getValue();
                unionParent(target.getKey(), target.getValue());
            }
            if (key == 1) { //같은팀인지 확인인
                Entry<Integer, Integer> target = command.getValue();
                int parent1 = findParent(target.getKey());
                int parent2 = findParent(target.getValue());
                if(parent1 == parent2) {
                    result.add("YES");
                } else {
                    result.add("NO");
                }
            }
        }
        return result;
    }

    /**
     *  [1] 1 , [1] 2, [3] 3, [3] 4
     *  1-3 => 1, 1, 1, 3
     *  1-3 => 3, 1, 3, 3
     * @param x
     * @return
     */
    public static int findParent(int x) {
        if (x == users[x]) {
            return x;
        }
        return users[x] = findParent(users[x]);
    }

    public static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a < b) users[b] = a;
        else users[a] = b;
    }
}
