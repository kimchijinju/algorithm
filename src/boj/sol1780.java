package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sol1780 {
    static int[][] paper;
    static int minusOne = 0;
    static int zero = 0;
    static int one = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        paper = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        divide(0, 0, N);
        System.out.println(minusOne);
        System.out.println(zero);
        System.out.println(one);
    }

    private static void divide(int y, int x, int size) {
        if (checkEquals(y, x, size)) {
            if (paper[y][x] == -1)
                minusOne++;
            if (paper[y][x] == 0)
                zero++;
            if (paper[y][x] == 1)
                one++;
            return;
        }
        int next = size / 3;
        divide(y, x, next);
        divide(y, x + next, next);
        divide(y, x + next + next, next);
        divide(y + next, x, next);
        divide(y + next + next, x, next);
        divide(y + next, x + next, next);
        divide(y + next + next, x + next, next);
        divide(y + next, x + next + next, next);
        divide(y + next + next, x + next + next, next);

    }

    private static boolean checkEquals(int y, int x, int size) {
        int compare = paper[y][x];
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (paper[i][j] != compare)
                    return false;
            }
        }
        return true;
    }
}
