package boj;

import java.util.Scanner;

public class sol2609 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int min = Math.min(num1, num2);
        int div = 1;
        int multi = 0;

        for(int i = min; i > 0; i--) {
            if(num1 % i == 0 && num2 % i == 0) {
                div = i;
                num1 /= i;
                num2 /= i;
                break;
            }
        }
        System.out.println(div + " " + div * num1 * num2);
    }
}
