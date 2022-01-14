package boj;

import java.util.Scanner;

public class sol9663 {
    static int[] chessBoard;
    static int N;
    static int answer = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();

        chessBoard = new int[N];

        search(0);
        System.out.println(answer);
    }

    private static void search(int count) {
        if (count == N) {
            answer++;
            return;
        }

        for (int i = 0; i < N; i++) {
            chessBoard[count] = i;
            if (canPlace(count))
                search(count + 1);
        }

    }

    private static boolean canPlace(int count) {
        for (int i = 0; i < count; i++) {
            if (chessBoard[count] == chessBoard[i] || Math.abs(chessBoard[count] - chessBoard[i]) == Math.abs(i - count))
                return false;
        }
        return true;
    }

}