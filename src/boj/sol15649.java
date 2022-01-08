package boj;

import java.util.Scanner;

public class sol15649 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        boolean[] visit = new boolean[N];
        int[] number = new int[M];

        search(visit, number, 0, N, M);
    }

    private static void search(boolean[] visit, int[] number, int count, int n, int m) {
        if (count == m) {
            for (int i : number)
                System.out.print(i + " ");

            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visit[i])
                continue;

            visit[i] = true;
            number[count] = i + 1;
            search(visit, number, count + 1, n, m);
            visit[i] = false;
        }

    }
}
