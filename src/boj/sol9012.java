package boj;

import java.util.Scanner;

public class sol9012 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < T; i++) {
            String str = scanner.nextLine();
            checkVPS(str);
        }
    }

    private static void checkVPS(String str) {
        myStack stack = new myStack();

        for (int j = 0; j < str.length(); j++) {
            if (str.charAt(j) == ')') {
                if(stack.empty() == 1) {
                    System.out.println("NO");
                    return ;
                }
                stack.pop();
                continue;
            }
            stack.push(str.charAt(j));
        }
        if(stack.empty() == 0) {
            System.out.println("NO");
            return ;
        }
        System.out.println("YES");
    }
}
