package boj;

import java.util.Scanner;

public class sol10819 {
    static int max = Integer.MIN_VALUE;
    static int[] A;
    static int N;
    static boolean[] visit;
    static int[] sortArray;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        A = new int[N];

        sortArray = new int[N];
        visit = new boolean[N];
        for (int i = 0; i < N; i++)
            A[i] = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            visit[i] = true;
            sortArray[0] = A[i];
            search(1);
            visit[i] = false;
        }
        System.out.println(max);
    }

    private static void search(int count) {
        if (A.length == count) {
            int sum = 0;
            for (int i = 0; i < N - 1; i++) {
                sum += Math.abs(sortArray[i] - sortArray[i + 1]);
            }
            max = Math.max(sum, max);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visit[i])
                continue;
            visit[i] = true;
            sortArray[count] = A[i];
            search(count + 1);
            visit[i] = false;
        }

    }
}
