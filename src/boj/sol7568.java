package boj;

import java.util.*;

public class sol7568 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        List<Body> bodyList = new ArrayList<>();

        for (int i = 0; i < N; i++)
            bodyList.add(new Body(scanner.nextInt(), scanner.nextInt()));

        for (int i = 0; i < N; i++) {
            int ranking = 1;

            for (int j = 0; j < N; j++) {
                if (i == j)
                    continue;

                if (bodyList.get(i).compare(bodyList.get(j)))
                    ranking++;
            }
            System.out.print(ranking + " ");
        }


    }
}

class Body {
    int weight;
    int height;

    public Body(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }

    public boolean compare(Body next) {
        return this.weight < next.weight && this.height < next.height;
    }
}