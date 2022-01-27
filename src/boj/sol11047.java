package boj;

import java.util.Scanner;

public class sol11047 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();

        int[] coin = new int[N];

        for (int i = N - 1; i >= 0; i--)
            coin[i] = scanner.nextInt();

        int answer = 0;
        int index = 0;
        while (K > 0) {
            if (K - coin[index] >= 0) {
                answer++;
                K -= coin[index];
                continue;
            }
            index++;
        }
        System.out.println(answer);


    }
}
