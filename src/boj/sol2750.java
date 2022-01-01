package boj;

import java.io.*;

public class sol2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];

        for (int i = 0; i < N; i++)
            numbers[i] = Integer.parseInt(br.readLine());

        sort(numbers);

        for (int num : numbers)
            bw.write(num + "\n");

        bw.flush();
        bw.close();
    }

    private static void sort(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] > numbers[j])
                    swap(numbers, i, j);
            }
        }

    }

    private static void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}
