package com.tistory.jeongpro.leetcode;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import sun.awt.image.ImageWatched;

import java.util.*;
import java.util.stream.Collectors;

@RestControllerAdvice
public class EasyTest {
    public int numJewelsInStones(String J, String S) {
        int count = 0;
        for(char c : J.toCharArray()){
            for(char s : S.toCharArray()){
                if(c == s){
                    count++;
                }
            }
        }
        return count;
    }
    public int[] decompressRLElist(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i+=2){
            for(int j=0;j<nums[i];j++){
                list.add(nums[i+1]);
            }
        }
        int[] result = new int[list.size()];
        for(int i=0;i<list.size();i++){
            result[i] = list.get(i);
        }
        return result;
    }
    public int subtractProductAndSum(int n) {
        int mul = 1;
        int sum = 0;
        while(n > 0){
            int value = n % 10;
            mul *= value;
            sum += value;
            n /= 10;
        }
        return mul - sum;
    }
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] cache = new int[101];
        for(int i=0;i<cache.length;i++){
            cache[i] = -1;
        }
        int[] result = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            int count = 0;
            if(cache[nums[i]] != -1){
                result[i] = cache[nums[i]];
                continue;
            }
            for(int j=0;j<nums.length;j++){
                if(nums[i] > nums[j]){
                    count++;
                }
            }
            cache[nums[i]] = count;
            result[i] = count;
        }
        return result;
    }
    public int findNumbers(int[] nums) {
        return (int) Arrays.stream(nums)
                .filter(x -> Integer.toString(x).length() % 2 == 0)
                .count();
    }
    public int balancedStringSplit(String s) {
        int count = 0;
        int check = 0;
        for(char c : s.toCharArray()){
            if(c == 'R'){
                check++;
            }else{
                check--;
            }
            if(check == 0){
                count++;
            }
        }
        return count;
    }
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> list = new LinkedList<>();
        for(int i=0;i<nums.length;i++){
            list.add(index[i], nums[i]);
        }
        int[] result = new int[list.size()];
        for(int i=0;i<list.size();i++){
            result[i] = list.get(i);
        }
        return result;
    }

    public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
    }
    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root == null){
            return 0;
        }
        if(root.val < L){
            return rangeSumBST(root.right, L, R);
        }
        if(root.val > R){
            return rangeSumBST(root.left, L, R);
        }
        return root.val + rangeSumBST(root.left,L,R) + rangeSumBST(root.right,L,R);
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public int getDecimalValue(ListNode head) {
        int sum = 0;
        while(head != null) {
            sum = sum * 2 + head.val;
            head = head.next;
        }
        return sum;
    }
    public int minTimeToVisitAllPoints(int[][] points) {
        int steps = 0;
        for (int i = 0; i < points.length - 1; i++) {
            steps += Math.max(Math.abs(points[i][1] - points[i + 1][1]), Math.abs(points[i][0] - points[i + 1][0]));
        }
        return steps;
    }
    public int[] replaceElements(int[] arr) {
        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length-1;i++)
        {
            // if current is the max, we need to find a new max
            if(arr[i] == max)
                max = Integer.MIN_VALUE;

            // find the max
            if(max == Integer.MIN_VALUE)
            {
                for(int j=i+1;j<arr.length;j++)
                {
                    max = Math.max(max, arr[j]);
                }
            }

            arr[i] = max;
        }
        arr[arr.length-1] = -1;
        return arr;
    }
    public int maximum69Number (int num) {
        Integer integer = Integer.valueOf(num);
        String str = integer.toString();
        if(str.indexOf('6') != -1){
            String str2 = str.replaceFirst("6", "9");
            num = Integer.parseInt(str2);
        }
        return num;
    }
    public int solution(String p, String s) {
        int answer = 0;
        for(int i=0;i<p.length();i++){
            int curr = Integer.valueOf(p.charAt(i));
            int target = Integer.valueOf(s.charAt(i));
            if(curr-target > 5){
                answer += 10 - (curr-target);
            }else if(curr-target < -5){
                answer += 10 + (curr-target);
            }else{
                answer += Math.abs(curr-target);
            }
        }
        return answer;
    }
    static int[] dx = { 0, 1, 0, -1 }; // 북 동 남 서
    static int[] dy = { -1, 0, 1, 0 };

    public int solution(int[][] office, int r, int c, String[] move) {
        int answer = 0;
        //첫번째칸 청소
        answer += office[r][c];
        office[r][c] = 0;
        //방향정보 초반 북
        int direction = 0;
        for(int i=0;i<move.length;i++){
            String command = move[i];
            if(command.equals("go")){
                int ny = r + dy[direction];
                int nx = c + dx[direction];
                if(nx >=0 && nx <office.length && ny >= 0 && ny < office.length){
                    if(office[ny][nx] != -1) {
                        r = ny;
                        c = nx;
                        answer += office[r][c];
                        office[r][c] = 0;
                    }
                }
            }else if(command.equals("left")){
                if(direction-1 < 0){
                    direction = 3;
                }else{
                    direction = direction - 1;
                }
            }else{
                direction = (direction+1)%4;
            }
            System.out.println("c:" + c + "r:"+r + "office" + answer);
        }
        return answer;
    }
    /*public int solution(int[] numbers, int K) {
        int answer = 0;
        int curr = hello(numbers, K);
        if(curr == 0){
            return 0;
        }
        answer++;
        candidate(numbers, K, curr);
        return answer;
    }*/
    /*public List<int[]> candidate(int[] numbers, int K, int curr){
        List<int[]> list = new ArrayList<>();
        for(int i=0;i<numbers.length-1){
            for(int j=1;j<numbers.length;j++){
                int temp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = temp;
                int swapped = hello(numbers, K);
                if(swapped < curr){
                    int[] candidate = Arrays.copyOf(numbers, numbers.length);
                    list.add(candidate);
                }
            }
        }
        return list;
    }*/
    static class Helloworld{
        private int[] numbers;
        private int swap;
        private int K;
        private int error;

        public void setK(int k) {
            K = k;
        }

        public void setNumbers(int[] numbers) {
            this.numbers = numbers;
        }

        public void setSwap(int swap) {
            this.swap = swap;
        }

        public int getK() {
            return K;
        }

        public int getSwap() {
            return swap;
        }

        public int[] getNumbers() {
            return numbers;
        }
    }
    public int hello(int[] numbers, int K) {
        int count = 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            int M = Math.abs(numbers[i] - numbers[i + 1]);
            if (M > K) {
                count++;
            }
        }
        return count;
    }
    public int countNegatives(int[][] grid) {
        int result = 0;
        for(int[] row : grid){
            Arrays.sort(row);
            for(int v : row){
                if(v >= 0){
                    break;
                }else{
                    result++;
                }
            }
        }
        return result;
    }
    public int[][] flipAndInvertImage(int[][] A) {
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[i].length;j++){
                if(A[i][j] == 0){
                    A[i][j] = 1;
                }else{
                    A[i][j] = 0;
                }
            }
        }
        return null;
    }
    public int[] sortArrayByParity(int[] A) {
        int [] result = new int[A.length];
        int start = 0;
        int end = result.length-1;
        for(int a : A){
            if(a%2 == 0){
                result[start++] = a;
            }else{
                result[end--] = a;
            }
        }
        return result;
    }
    public int repeatedNTimes(int[] A) {
        Set<Integer> set = new HashSet<>();
        for(int a : A){
            if(set.contains(a)){
                return a;
            }else{
                set.add(a);
            }
        }
        return 0;
    }
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<matrix.length;i++){
            int min = Integer.MAX_VALUE;
            int col = 0;
            for(int j=0;j<matrix[i].length;j++){
                if(min > matrix[i][j]){
                    min = matrix[i][j];
                    col = j;
                }
            }
            int max = min;
            for(int j=0;j<matrix.length;j++){
                if(max < matrix[j][col]){
                    max = matrix[j][col];
                }
            }
            if(max == min){
                res.add(min);
            }
        }
        return res;
    }
    public int hammingDistance(int x, int y) {

        int xor = x^y;
        int ctr = 0;

        while(xor!=0) {
            ctr+=xor&1;
            xor=xor>>1;
        }
        return ctr;
    }
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> list = new ArrayList<Integer>(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        int sum = 0;
        for(int i : nums){
            sum += i;
        }
        list.sort((a,b)->b-a);

        return null;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    class Solution {
        public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
            if (t1.left == null) {
                t1.left = t2.left;
            }
            if (t1 != null && t2 != null) {
                t1.val += t2.val;
            }
            Set<Integer> set = new HashSet<>();
            List<Integer> list = new ArrayList<>();
            int[] a = new int[5];
            list.removeIf((x) -> x == a[1]);
            StringBuilder sb = new StringBuilder();
            String[] str = {};
            String s = "!11";
            return null;
        }

        /**
         * DI String Match
         */
        public int[] diStringMatch(String S) {
            int[] result = new int[S.length() + 1];
            int start = 0;
            int end = S.length();
            for (int i = 0; i < S.length(); i++) {
                if (S.charAt(i) == 'I') {
                    result[i] = start;
                    start++;
                } else {
                    result[i] = end;
                    end--;
                }
            }
            result[result.length - 1] = end;
            return result;
        }
    }
}
