package boj;

import java.util.Scanner;

public class sol3036 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] rings = new int[N];
        for (int i = 0; i < N; i++)
            rings[i] = scanner.nextInt();

        for (int i = 1; i < N; i++) {
            int gcd = gcd(rings[0], rings[i]);
            System.out.println(rings[0] / gcd + "/" + rings[i] / gcd);
        }
    }

    private static int gcd(int a, int b) {
        if (a % b == 0)
            return b;
        return gcd(b, a % b);
    }
}
