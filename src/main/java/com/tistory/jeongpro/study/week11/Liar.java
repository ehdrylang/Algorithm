package com.tistory.jeongpro.study.week11;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 거짓말하는 친구가 최대한 많은 파티에 참여해서 거짓말 하는 방법
 * 1. 진실을 아는 사람이 있는 파티에서는 당연히 거짓말을 못한다.
 * 2. 진실을 아는 사람이 있는 파티원 중에 진실을 모르는 사람도 해당 파티에서 거짓말하다 걸리기 때문에 독립적인 사람들에게만 거짓말이 가능하다.
 */
public class Liar {
    private static int[] parents;

    public static int solution(int n, List<Integer> knownUsers, List<List<Integer>> parties) {
        // 진실을 아는 사람이 없으면 모든 파티에서 거짓말 칠 수 있음
        if (knownUsers.isEmpty()) {
            return parties.size();
        }
        parents = new int[n + 1];
        // 부모 초기화
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
        // 부모 합치기 들어갑니다
        for (List<Integer> party : parties) {
            if (party.size() > 1) { // 두 명이상이 참여하는 파티여야 묶을 대상이 있지
                for (int i = 0; i < party.size() - 1; i++) {
                    unionParent(party.get(i), party.get(i + 1));
                }
            }
        }
        // 진실을 아는 사람과 같은 부모를 가진 사람들은 진실만 들어야하므로 리스트에 추가
        Set<Integer> set = new HashSet<>();
        for (Integer integer : knownUsers) {
            int parent = findParent(integer);
            for (int i = 0; i < parents.length; i++) {
                if (parent == parents[i]) {
                    set.add(i);
                }
            }
        }
        int result = 0;
        // 파티 돌면서 파티 참여 가능한지 검사
        for (List<Integer> party : parties) {
            boolean joinable = true;
            for (Integer user : party) {
                if (set.contains(user)) {
                    joinable = false;
                }
            }
            if (joinable) {
                result++;
            }
        }
        return result;
    }

    public static int findParent(int x) {
        if (x == parents[x]) {
            return x;
        }
        return parents[x] = findParent(parents[x]);
    }

    public static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a > b) {
            parents[b] = a;
        } else {
            parents[a] = b;
        }
    }
}
