package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sol2630 {

    static int blue = 0;
    static int white = 0;
    static int[][] square;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        square = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                square[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        divide(0, 0, N);
        System.out.println(white);
        System.out.println(blue);
    }

    private static void divide(int y, int x, int size) {
        if (onlyOneColor(y, x, size)) {
            if (square[y][x] == 1)
                blue++;
            if (square[y][x] == 0)
                white++;
            return;
        }
        int next = size / 2;
        divide(y, x, next);
        divide(y + next, x, next);
        divide(y, x + next, next);
        divide(y + next, x + next, next);
    }

    private static boolean onlyOneColor(int y, int x, int size) {
        int compare = square[y][x];
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (square[i][j] != compare)
                    return false;
            }
        }
        return true;
    }
}
