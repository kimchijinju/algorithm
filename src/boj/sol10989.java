package boj;

import java.io.*;

public class sol10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int[] numbers = new int[N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
            if (max < numbers[i] + 1)
                max = numbers[i] + 1;
        }

        int[] numbersCount = new int[max];
        for (int i = 0; i < N; i++)
            numbersCount[numbers[i]]++;

        for (int i = 1; i < max; i++) {
            numbersCount[i] += numbersCount[i - 1];
        }


        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            numbersCount[numbers[i]]--;
            answer[numbersCount[numbers[i]]] = numbers[i];
        }

        for (int i : answer)
            bw.write(i + "\n");
        bw.flush();
        bw.close();
    }
}
