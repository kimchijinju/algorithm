package boj;

import java.util.Scanner;

public class sol1541 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String formula = scanner.nextLine();
        String[] numbers = formula.split("\\+|-");

        int index = 1;
        int answer = Integer.parseInt(numbers[0]);
        boolean hasMinus = false;
        for (int i = 0; i < formula.length() && index < numbers.length; i++) {
            if (hasMinus) {
                answer -= Integer.parseInt(numbers[index++]);
                continue;
            }

            if (formula.charAt(i) == '+')
                answer += Integer.parseInt(numbers[index++]);

            if (formula.charAt(i) == '-') {
                answer -= Integer.parseInt(numbers[index++]);
                hasMinus = true;
            }
        }

        System.out.println(answer);

    }
}
