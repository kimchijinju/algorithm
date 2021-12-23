package boj;

import java.util.*;

public class sol2798 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int[] cards = new int[N];
        for (int i = 0; i < N; i++)
            cards[i] = scanner.nextInt();

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    int result = cards[i] + cards[j] + cards[k];

                    if (M == result) {
                        System.out.print(M);
                        return;
                    }
                    if(result < M && result > answer)
                        answer = result;
                }
            }
        } // for
        System.out.print(answer);

    }

}
