package com.tistory.jeongpro.greedy;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.beans.ConstructorProperties;

/**
 *  문제 설명
 * 조이스틱으로 알파벳 이름을 완성하세요. 맨 처음엔 A로만 이루어져 있습니다.
 * ex) 완성해야 하는 이름이 세 글자면 AAA, 네 글자면 AAAA
 *
 * 조이스틱을 각 방향으로 움직이면 아래와 같습니다.
 *
 * ▲ - 다음 알파벳
 * ▼ - 이전 알파벳 (A에서 아래쪽으로 이동하면 Z로)
 * ◀ - 커서를 왼쪽으로 이동 (첫 번째 위치에서 왼쪽으로 이동하면 마지막 문자에 커서)
 * ▶ - 커서를 오른쪽으로 이동
 * 예를 들어 아래의 방법으로 JAZ를 만들 수 있습니다.
 *
 * - 첫 번째 위치에서 조이스틱을 위로 9번 조작하여 J를 완성합니다.
 * - 조이스틱을 왼쪽으로 1번 조작하여 커서를 마지막 문자 위치로 이동시킵니다.
 * - 마지막 위치에서 조이스틱을 아래로 1번 조작하여 Z를 완성합니다.
 * 따라서 11번 이동시켜 "JAZ"를 만들 수 있고, 이때가 최소 이동입니다.
 * 만들고자 하는 이름 name이 매개변수로 주어질 때, 이름에 대해 조이스틱 조작 횟수의 최솟값을 return 하도록 solution 함수를 만드세요.
 *
 * 제한 사항
 * name은 알파벳 대문자로만 이루어져 있습니다.
 * name의 길이는 1 이상 20 이하입니다.
 * 입출력 예
 * name  	return
 * JEROEN	56
 * JAN	    23
 * 출처
 *
 * ※ 공지 - 2019년 2월 28일 테스트케이스가 추가되었습니다.
 */
@Component
public class JoyStick {
    @PostConstruct
    private void test(){

    }
    public int solution(String name) {
        int answer = 0;
        //A가 있는 곳과 아닌 곳으로 구분한다.
        boolean[] check = new boolean[name.length()];
        int count = 0;//아닌 게 몇 개인지 확인해서 그 만큼만 작업을 수행하려고 카운트
        for(int i=0;i<name.length();i++){
            if(name.charAt(i) == 'A'){
                check[i] = true;
            }else{
                count++;
            }
        }
        int idx = 0;//첫 위치는 항상 0
        for(int i=0;i<count;i++){
            if(check[idx]){
                //좌우로 움직일 때 최적해를 찾고
                int[] res = searchMinLeftRight(idx, check);
                answer += res[0];
                idx = res[1];
                //해당 값을 처리해줌
            }
            answer += searchMinUpDown(name.charAt(idx));
            check[idx] = true;
        }
        return answer;
    }
    public int[] searchMinLeftRight(int idx, boolean[] check){
        int[] res = new int[2];
        int left = idx;
        int leftCount = 0;
        int right = idx;
        int rightCount = 0;
        //왼쪽 횟수를 구한다.
        while(true){
            left--;
            leftCount++;
            if(left < 0){
                left = check.length - 1;
            }
            if(!check[left]){
                break;
            }
        }
        //오른쪽 횟수를 구한다.
        while(true){
            right++;
            rightCount++;
            if(right == check.length){
                right = 0;
            }
            if(!check[right]){
                break;
            }
        }
        if(leftCount >= rightCount) {
            res[0] = rightCount;
            res[1] = right;
        }else{
            res[0] = leftCount;
            res[1] = left;
        }
        return res;
    }
    public int searchMinUpDown(char c){
        int up = c - 'A';
        int down = 'Z' - c + 1; //기준인 'Z'가 이미 한칸 움직인 것 이기 때문에 +1
        return up > down ? down : up;
    }
}
