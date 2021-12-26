package boj;

import java.util.Scanner;

public class sol2231 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        for(int i = 0; i < 1_000_000; i++) {
            if(sumOfDigit(i) == N){
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);

    }

    private static int sumOfDigit(int i) {
        int result = i;
        while(i > 0){
            result += i % 10;
            i /= 10;
        }

        return result;
    }
}
