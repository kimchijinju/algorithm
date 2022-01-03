package boj;


import java.io.*;
import java.util.*;

public class sol2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];

        double sum = 0;
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
            sum += numbers[i];
            map.put(numbers[i], map.getOrDefault(numbers[i], 0) + 1);
        }


        Arrays.sort(numbers);
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue(Collections.reverseOrder()));

        int most = list.get(0).getKey();
        int i1 = list.get(0).getValue();
        int i2 = 0;

        if (list.size() > 1)
            i2 = list.get(1).getValue();
        if (i1 == i2)
            most = list.get(1).getKey();

        sum = (int) Math.round(sum / N);
        int range = map.lastKey() - map.firstKey();
        int middle = numbers[N / 2];

        System.out.println((int) sum + "\n" + middle + "\n" + most + "\n" + range + "\n");

    }
}
