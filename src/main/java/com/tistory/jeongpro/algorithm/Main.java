import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String input1 = sc.nextLine();
        String[] strArr = input1.split(" ");
        int N = Integer.parseInt(strArr[0]);
        int K = Integer.parseInt(strArr[1]);
        String target = sc.nextLine();
        int max = Integer.MIN_VALUE;
        for(int i=0;i<target.length()-K;i++){
            int value = Integer.parseInt(target.substring(i,i+K));
            if(value > max){
                max = value;
            }
        }
        if(N == K){
            max = Integer.parseInt(target);
        }
        System.out.println(max);
    }
}
