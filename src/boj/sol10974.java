package boj;

import java.util.Scanner;

public class sol10974 {
    static int N;
    static int[] answer;
    static boolean[] visit;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        answer = new int[N];
        visit = new boolean[N];

        search(0);

    }

    private static void search(int count) {
        if (count == N) {
            for (int i : answer)
                System.out.print(i + " ");
            System.out.println();
        }

        for (int i = 0; i < N; i++) {
            if (visit[i])
                continue;
            visit[i] = true;
            answer[count] = i + 1;
            search(count + 1);
            visit[i] = false;
        }

    }

}
