package boj;

import java.util.Arrays;
import java.util.Scanner;

public class sol1759 {
    static int L;
    static int C;
    static boolean[] visit;
    static char[] words;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        L = scanner.nextInt();
        C = scanner.nextInt();

        words = new char[C];
        visit = new boolean[C];

        for (int i = 0; i < C; i++)
            words[i] = scanner.next().charAt(0);

        Arrays.sort(words);

        search(0, new char[L]);
    }

    private static void search(int index, char[] password) {
        if (index == L) {
            if (hasVowel(password)) {
                for (char p : password)
                    System.out.print(p);
                System.out.println();
                return;
            }
            return;
        }

        for (int i = 0; i < C; i++) {
            if (visit[i])
                continue;
            visit[i] = true;
            password[index] = words[i];
            search(index + 1, password);
            for (int j = i + 1; j < C; j++)
                visit[j] = false;
        }

    }

    private static boolean hasVowel(char[] password) {
        int vowel = 0;
        int consonant = 0;
        for (char c : password) {
            if (c == 'a' || c == 'e' ||
                    c == 'i' || c == 'o' || c == 'u') {
                vowel++;
                continue;
            }
            consonant++;
        }
        return vowel >= 1 && consonant >= 2;
    }


}
