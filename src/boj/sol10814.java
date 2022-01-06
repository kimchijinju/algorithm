import java.util.Arrays;
import java.util.Scanner;

public class sol10814 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        Account[] accounts = new Account[N];
        for (int i = 0; i < N; i++) {
            accounts[i] = new Account(i, scanner.nextInt(), scanner.nextLine());
        }

        Arrays.sort(accounts);

        for (Account account : accounts)
            System.out.println(account);
    }

    static class Account implements Comparable<Account> {
        int order;
        int age;
        String name;

        public Account(int order, int age, String name) {
            this.order = order;
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return age + name;
        }

        @Override
        public int compareTo(Account o) {
            if (age > o.age)
                return 1;

            if (age == o.age) {
                if (order > o.order)
                    return 1;
            }

            return -1;

        }
    }
}

