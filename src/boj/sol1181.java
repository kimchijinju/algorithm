package boj;

import java.util.*;

public class sol1181 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();
        Set<String> wordSet = new HashSet<>();

        for (int i = 0; i < N; i++)
            wordSet.add(scanner.nextLine());

        String[] words = new String[wordSet.size()];
        wordSet.toArray(words);

        Arrays.sort(words, (o1, o2) -> {
            if (o1.length() > o2.length())
                return 1;
            if (o1.length() == o2.length())
                return o1.compareTo(o2);

            return -1;
        });


        for (String word : words)
            System.out.println(word);

    }
}


