package boj;

import java.util.Scanner;

public class sol1934 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int i = -1;
        while(++i < T) {
            int num1 = scanner.nextInt();
            int num2 = scanner.nextInt();
            int max = Math.max(num1, num2);
            int min = Math.min(num1, num2);
            System.out.println(max * min / euclid(max, min));
        }
    }

    private static int euclid(int max, int min) {
        if(max % min == 0) {
            return min;
        }
        return euclid(min, max % min);
    }
}
