package boj;

import java.util.Arrays;
import java.util.Scanner;

public class sol11399 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] people = new int[N];

        for (int i = 0; i < N; i++)
            people[i] = scanner.nextInt();

        Arrays.sort(people);

        int answer = people[0];
        for (int i = 1; i < N; i++) {
            people[i] += people[i - 1];
            answer += people[i];
        }

        System.out.println(answer);


    }
}
