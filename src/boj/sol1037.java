package boj;

import java.util.Arrays;
import java.util.Scanner;

public class sol1037 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] factor = new int[N];
        for (int i = 0; i < N; i++)
            factor[i] = scanner.nextInt();
        Arrays.sort(factor);
        System.out.println(factor[0] * factor[N - 1]);
    }
}
