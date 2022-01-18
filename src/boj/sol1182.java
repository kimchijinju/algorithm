package boj;

import java.util.Scanner;

public class sol1182 {
    static int answer = 0;
    static int S;
    static int[] seq;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        S = scanner.nextInt();
        seq = new int[N];

        for (int i = 0; i < N; i++)
            seq[i] = scanner.nextInt();

        search(0, 0);
        System.out.println(answer);
    }

    private static void search(int sum, int index) {
        if (index == seq.length)
            return;

        if (sum + seq[index] == S)
            answer++;


        search(sum, index + 1);
        search(sum + seq[index], index + 1);

    }
}
