package boj;

import java.util.Scanner;

public class sol1149 {
    static final int R = 0;
    static final int G = 1;
    static final int B = 2;
    static int N;
    static int[][] RGB;
    static int[][] answer;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();

        RGB = new int[N + 1][3];
        answer = new int[N + 1][3];

        for (int i = 1; i <= N; i++) {
            RGB[i][R] = scanner.nextInt();
            RGB[i][G] = scanner.nextInt();
            RGB[i][B] = scanner.nextInt();
        }

        for(int count = 1; count <= N; count++) {
            answer[count][R] = Math.min(answer[count - 1][G], answer[count - 1][B]) + RGB[count][R];
            answer[count][G] = Math.min(answer[count - 1][R], answer[count - 1][B]) + RGB[count][G];
            answer[count][B] = Math.min(answer[count - 1][G], answer[count - 1][R]) + RGB[count][B];
        }

        System.out.println(Math.min(Math.min(answer[N][0],answer[N][1]),answer[N][2]));

    }

}
