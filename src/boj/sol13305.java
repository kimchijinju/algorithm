package boj;

import java.util.Scanner;

public class sol13305 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        long[] length = new long[N - 1];
        long[] oil = new long[N];

        for (int i = 0; i < N - 1; i++)
            length[i] = scanner.nextInt();

        for (int i = 0; i < N; i++)
            oil[i] = scanner.nextInt();

        long answer = oil[0] * length[0];
        long min = oil[0];
        for (int i = 1; i < N - 1; i++) {
            if (min > oil[i])
                min = oil[i];

            answer += min * length[i];
        }

        System.out.println(answer);


    }


}
