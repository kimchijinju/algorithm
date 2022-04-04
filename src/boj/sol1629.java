package boj;

import java.util.Scanner;

public class sol1629 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        long d = pow(A, B, C);
        System.out.println(d);
    }

    private static long pow(int a, int b, int c) {
        if (b == 0)
            return 1;
        long temp = pow(a, b / 2, c);
        temp = temp * temp % c;
        if(b % 2 == 0)
            return temp;
        return a * temp % c;
    }
}
