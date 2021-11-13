package com.tistory.jeongpro.study.week8;

/**
 * 문자열로 주어진 두 양의 정수를 곱하여 값을 얻는데 Integer 클래스 이용 금지
 */
public class MultiString {
    public String multiply(String num1, String num2) {
        // 둘 중 하나 0이면 0
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int[] result = new int[num1.length() + num2.length() + 1];
        int pointerIdx = result.length-1;
        for (int i = num1.length() - 1; i >= 0; i--) {

            int n = num1.charAt(i) - '0';
            int pointerIdx2 = pointerIdx;
            for (int j = num2.length() - 1; j >= 0; j--) {

                int m = num2.charAt(j) - '0';
                int idx = pointerIdx2; // 넣어야하는 자리수
                int mid = (n * m) + result[idx]; // 중간 계산 결과
                result[idx] = mid % 10;
                result[idx - 1] += mid / 10;
                pointerIdx2--;
            }
            pointerIdx--;
        }
        StringBuilder sb = new StringBuilder();
        int index;
        for (index = 0; index < result.length; index++) {
            if (result[index] != 0) {
                break;
            }
        }
        for(int i=index;i<result.length;i++) {
            sb.append(result[i]);
        }
        return sb.toString();
    }
}
