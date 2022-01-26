package boj;

import java.util.Scanner;

public class sol2156 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] wine = new int[n + 1];
        int[] answer = new int[n + 1];

        if(n == 1){
            System.out.println(scanner.nextInt());
            return;
        }

        for (int i = 1; i <= n; i++)
            wine[i] = scanner.nextInt();

        answer[1] = wine[1];
        answer[2] = wine[1] + wine[2];
        for (int i = 3; i <= n; i++) {
            answer[i] = Math.max(answer[i - 3] + wine[i - 1] + wine[i], answer[i - 2] + wine[i]);
            answer[i] = Math.max(answer[i - 1], answer[i]);
        }

        System.out.println(answer[n]);


    }
}
