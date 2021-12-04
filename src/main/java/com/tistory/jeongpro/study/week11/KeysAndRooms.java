package com.tistory.jeongpro.study.week11;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 열쇠와 방
 * 0번 룸만 열려있고 그 안에는 키가 N개가 있을 수 있음
 * 해당 키를 가지고 모든 방을 접근할 수 있는지 없는지 true, false 리턴
 */
public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> set = new HashSet<>(); //
        return dfs(rooms, set, 0);
    }

    private boolean dfs(List<List<Integer>> rooms, Set<Integer> set, int roomNumber) {
        set.add(roomNumber); // 방문한 방 번호 넣기
        if (set.size() == rooms.size()) { // 주어진 룸 수와 방문한 룸 개수가 같으면 전부 방문 한 것이므로 true
            return true;
        }

        for (int room : rooms.get(roomNumber)) {
            if (!set.contains(room)) { // 놓여진 키가 방문하지 않은 룸이면 dfs 한 번 더
                if (dfs(rooms, set, room)) {
                    return true;
                }
            }
        }
        return false;
    }
}
