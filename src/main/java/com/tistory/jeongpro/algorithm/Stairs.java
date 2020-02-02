package com.tistory.jeongpro.algorithm;

import java.util.Scanner;

/**
 * 계단 오르기 게임은 계단 아래 시작점부터 계단 꼭대기에 위치한 도착점까지 가는 게임이다. <그림 1>과 같이 각각의 계단에는 일정한 점수가 쓰여 있는데 계단을 밟으면 그 계단에 쓰여 있는 점수를 얻게 된다.
 *
 *
 *
 * 예를 들어 <그림 2>와 같이 시작점에서부터 첫 번째, 두 번째, 네 번째, 여섯 번째 계단을 밟아 도착점에 도달하면 총 점수는 10 + 20 + 25 + 20 = 75점이 된다.
 *
 *
 *
 * 계단 오르는 데는 다음과 같은 규칙이 있다.
 *
 * 계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다. 즉, 한 계단을 밟으면서 이어서 다음 계단이나, 다음 다음 계단으로 오를 수 있다.
 * 연속된 세 개의 계단을 모두 밟아서는 안 된다. 단, 시작점은 계단에 포함되지 않는다.
 * 마지막 도착 계단은 반드시 밟아야 한다.
 * 따라서 첫 번째 계단을 밟고 이어 두 번째 계단이나, 세 번째 계단으로 오를 수 있다. 하지만, 첫 번째 계단을 밟고 이어 네 번째 계단으로 올라가거나, 첫 번째, 두 번째, 세 번째 계단을 연속해서 모두 밟을 수는 없다.
 *
 * 각 계단에 쓰여 있는 점수가 주어질 때 이 게임에서 얻을 수 있는 총 점수의 최댓값을 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 입력의 첫째 줄에 계단의 개수가 주어진다.
 *
 * 둘째 줄부터 한 줄에 하나씩 제일 아래에 놓인 계단부터 순서대로 각 계단에 쓰여 있는 점수가 주어진다. 계단의 개수는 300이하의 자연수이고, 계단에 쓰여 있는 점수는 10,000이하의 자연수이다.
 *
 * 출력
 * 첫째 줄에 계단 오르기 게임에서 얻을 수 있는 총 점수의 최댓값을 출력한다.
 *
 * 문제풀이
 *  내 촉에는 마지막 계단을 반드시 밟아야하는게 일단 포인트고 동적계획법에 따르면 마지막 계단을 밟기 1칸전이나 2칸전까지의 최대값이 최대값 아니냐 이거지
 *  근데 연속 세개는 못밟아 그러면 그것도 카운트 해줘야하는데 일단 낮은 계단부터 각본다.
 *  -> 틀렸음
 *  마지막 계단을 밟아야하니까 마지막 전계단을 밟고오냐 안밟고오냐를 따져봐
 *  마지막 전 계단을 밟았으면 마지막 계단은 무조건 밟아야하니까 마지막 전전계단은 절대 밟지 않았겠지
 */
public class Stairs {
    private static int[] stairs = new int[301]; //계단값 저장
    private static int[] maxValues = new int[301]; //최대값 저장

    public int hello(){
        Scanner sc = new Scanner(System.in);
        int stairsCount = Integer.parseInt(sc.nextLine());
        for(int i=1;i<=stairsCount;i++){
            stairs[i] = Integer.parseInt(sc.nextLine());
        }
        maxValues[0] = stairs[0] = 0;
        maxValues[1] = stairs[1];
        maxValues[2] = stairs[2];
        for(int i=3;i<stairsCount;i++){
            maxValues[i] = Integer.max(stairs[i] + stairs[i-1] + maxValues[i-3], stairs[i] + maxValues[i-2]);
        }
        return maxValues[stairsCount];
    }
}
