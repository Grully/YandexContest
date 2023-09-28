package org.example;

import java.util.*;

public class MoscowCity {

    static void task(){
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        List<Integer> segments = new ArrayList<>();
        Map<Integer, Integer> mapOfDigging = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int di = scanner.nextInt();
            int wi = scanner.nextInt();
            int last = mapOfDigging.getOrDefault(wi, di);
            if (di - last > 0) {
                segments.add(di - last);
            }
            mapOfDigging.put(wi, di);
        }
        if (mapOfDigging.size() > m) {
            System.out.println(-1);
        } else {
            int unfixed = Math.max(0, segments.size() + mapOfDigging.size() - m);
            int sum = 0;
            Collections.sort(segments);
            for (int i = 0; i < unfixed; i++) {
                sum += segments.get(i);
            }
            System.out.println(sum);
        }
    }

    public static void main(String[] args) {
        task();
    }
}
