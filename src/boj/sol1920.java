package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sol1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());
        int[] cmp = new int[M];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++)
            cmp[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(A);
        for (int i = 0; i < M; i++) {
            int start = 0;
            int end = A.length - 1;
            int mid = (start + end) / 2;
            boolean flag = false;
            while (end - start >= 0) {
                if (cmp[i] == A[mid]) {
                    System.out.println(1);
                    flag = true;
                    break;
                } else if (cmp[i] < A[mid]) {
                    end = mid - 1;
                } else if (cmp[i] > A[mid]) {
                    start = mid + 1;
                }
                mid = (start + end) / 2;
            }
            if (!flag)
                System.out.println(0);
        }

//        for (int i = 0; i < M; i++) {
//            int search = N / 2;
//            boolean flag = false;
//            for (int j = 0; j < N; j++) {
//                if (search < N && cmp[i] == A[search]) {
//                    System.out.println(1);
//                    flag = true;
//                    break;
//                }
//                if (search < N && cmp[i] > A[search])
//                    search += search / 2;
//                if (search < N && cmp[i] < A[search])
//                    search /= 2;
//            }
//            if (!flag)
//                System.out.println(0);
//        }
    }
}
