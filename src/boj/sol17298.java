package boj;

import java.io.*;
import java.util.StringTokenizer;

public class sol17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] answer = new int[N];
        myStack stack = new myStack();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        for (int i = N - 1; i >= 0; i--) {
            while (stack.empty() == 0 && stack.top() <= A[i])
                stack.pop();
            if (stack.top() > A[i])
                answer[i] = stack.top();
            else
                answer[i] = -1;
            stack.push(A[i]);
        }
        for (int n : answer)
            bw.write(n + " ");
        bw.flush();
        bw.close();
        br.close();

    }
}
