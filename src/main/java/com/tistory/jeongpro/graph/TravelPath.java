package com.tistory.jeongpro.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 프로그래머스 여행경로
 */
public class TravelPath {
    public static StringBuilder sb = new StringBuilder();
    public static List<String> routes = new ArrayList<>();
    public static boolean[] used;
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        boolean[] used = new boolean[tickets.length];
        for(int i=0;i<tickets.length;i++){
            String start = tickets[i][0];
            String end = tickets[i][1];

            if(start.equalsIgnoreCase("ICN")){
                used[i] = true;
                sb.append(start).append(",");
                dfs(tickets, end, 1);
                used[i] = false;
            }
        }
        return answer;
    }
    public static void dfs(String[][] tickets, String end, int count){
        sb.append(end).append(",");
        if(count == tickets.length){
            routes.add(sb.toString());
            return;
        }
        for(int i=0;i<tickets.length;i++){
            String start = tickets[i][0];
            String end2 = tickets[i][1];
            if(end.equalsIgnoreCase(start) && !used[i]){
                used[i] = true;
                dfs(tickets, end2, count++);
                used[i] = false;
                sb.substring(0, sb.length()-4);
            }
        }
    }
}
