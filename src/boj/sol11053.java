package boj;

import java.util.Arrays;
import java.util.Scanner;

public class sol11053 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int[] seq = new int[A];
        int[] check = new int[1001];
        int max = 0;
        for (int i = 0; i < A; i++)
            seq[i] = scanner.nextInt();

        for (int i = 0; i < A; i++) {
            int count = 0;
            check[i] = 1;
            for (int j = 0; j < i; j++) {
                if (seq[i] > seq[j])
                    count = Math.max(count, check[j]);
            }
            check[i] += count;
            max = Math.max(check[i], max);
        }
        System.out.println(max);
    }
}
