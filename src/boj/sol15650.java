package boj;

import java.util.Scanner;

public class sol15650 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        boolean[] visit = new boolean[N];
        int[] list = new int[M];

        search(visit, list, 0, N, M);
    }

    private static void search(boolean[] visit, int[] list, int count, int n, int m) {
        if (count == m) {
            for (int i : list)
                System.out.print(i + " ");
            System.out.println();
            return;
        }
        for (int i = 0; i < n; i++) {
            if (visit[i])
                continue;

            visit[i] = true;
            list[count] = i + 1;
            search(visit, list, count + 1, n, m);
            for(int j = i + 1; j < n; j++)
                visit[j] = false;
        }
    }

}
