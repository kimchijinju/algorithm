package boj;

import java.util.Scanner;

public class sol4949 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String str = scanner.nextLine();
            if (str.equals("."))
                return;
            checkBrackets(str);
        }

    }

    private static void checkBrackets(String str) {
        myStack brackets = new myStack();

        for (int j = 0; j < str.length(); j++) {
            if (str.charAt(j) == ')' || str.charAt(j) == ']') {
                if (brackets.empty() == 1) {
                    System.out.println("no");
                    return;
                }
                if (str.charAt(j) == ')' && brackets.top() == '(') {
                    brackets.pop();
                    continue;
                }
                if (str.charAt(j) == ']' && brackets.top() == '[') {
                    brackets.pop();
                    continue;
                }
                System.out.println("no");
                return ;
            }
            if (str.charAt(j) == '(' || str.charAt(j) == '[')
                brackets.push(str.charAt(j));
        }
        if (brackets.empty() == 0) {
            System.out.println("no");
            return;
        }
        System.out.println("yes");
    }

}
