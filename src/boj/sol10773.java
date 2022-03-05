package boj;

import java.util.Scanner;

public class sol10773 {
    public static void main(String[] args) {
        myStack stack = new myStack();

        initStack(stack);

        int answer = 0;
        while (stack.empty() == 0)
            answer += stack.pop();

        System.out.println(answer);
    }

    private static void initStack(myStack stack) {
        Scanner scanner = new Scanner(System.in);
        int K = scanner.nextInt();
        for (int i = 0; i < K; i++) {
            int n = scanner.nextInt();
            stack.push(n);
            if (n == 0) {
                stack.pop();
                stack.pop();
            }
        }
    }
}