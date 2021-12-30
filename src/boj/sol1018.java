package boj;

import java.util.Arrays;
import java.util.Scanner;

public class sol1018 {

    private static final int BOARD_LENGTH = 8;

    private static final char[][] BLACK = {
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}};

    private static final char[][] WHITE = {
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}};


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        scanner.nextLine();
        char[][] chessBoard = new char[N][M];

        for (int i = 0; i < N; i++) {
            String board = scanner.nextLine();
            for (int j = 0; j < M; j++) {
                chessBoard[i][j] = board.charAt(j);
            }
        }

        int answer = 64;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i + 7 < N && j + 7 < M) {
                    answer = search(i, j, chessBoard, answer);
                }
            }
        }

        System.out.println(answer);

    }

    public static int search(int n, int m, char[][] chessBoard, int answer) {
        int startBlack = 0;
        int startWhite = 0;

        for (int i = n; i < n + BOARD_LENGTH; i++) {
            for (int j = m; j < m + BOARD_LENGTH; j++) {
                if (chessBoard[i][j] != BLACK[i - n][j - m])
                    startBlack++;

                if (chessBoard[i][j] != WHITE[i - n][j - m])
                    startWhite++;
            }
        }

        int result = Math.min(startBlack, startWhite);
        return Math.min(result, answer);
    }


}
