package boj;

import java.util.Scanner;

public class sol14888 {
    static int[] operator;
    static int[] A;
    static int N;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        A = new int[N];
        operator = new int[4];

        for (int i = 0; i < N; i++)
            A[i] = scanner.nextInt();

        for (int i = 0; i < 4; i++)
            operator[i] = scanner.nextInt();

        search(A[0], 1);
        System.out.println(max);
        System.out.println(min);
    }

    private static void search(int num, int index) {
        if (index == N) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {
                operator[i]--;

                switch (i) {
                    case 0:
                        search(num + A[index], index + 1);
                        break;
                    case 1:
                        search(num - A[index], index + 1);
                        break;
                    case 2:
                        search(num * A[index], index + 1);
                        break;
                    case 3:
                        search(num / A[index], index + 1);
                        break;
                }
                operator[i]++;
            }
        }


    }
}
