package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sol1992 {
    static int[][] tree;
    static boolean[] draw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        tree = new int[N][N];
        draw = new boolean[N * N];
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                tree[i][j] = Integer.parseInt(s[j]);
            }
        }
        divide(0, 0, N, 0);
    }

    private static void divide(int y, int x, int size, int depth) {
        boolean mark = draw[depth];
        if (isSame(y, x, size)) {
            System.out.print(tree[y][x]);
            return;
        }
        if(!mark) {
            System.out.print("(");
            draw[depth] = true;
        }

        int next = size / 2;

        divide(y, x, next, depth + 1);
        divide(y, x + next, next, depth + 1);
        divide(y + next, x, next, depth + 1);
        divide(y + next, x + next, next, depth + 1);
        if(!mark)
            System.out.print(")");
        draw[depth] = false;
    }

    private static boolean isSame(int y, int x, int n) {
        int compare = tree[y][x];
        for (int i = y; i < y + n; i++) {
            for (int j = x; j < x + n; j++) {
                if (compare != tree[i][j])
                    return false;
            }
        }
        return true;
    }
}
