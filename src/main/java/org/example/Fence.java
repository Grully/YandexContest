package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Fence {
    static long dif(int a, int b, long[] c) {

        Arrays.sort(c);
        long res = c[c.length -1] - c[0];
        for (int i = 0; i < b; i++) {
            if(c[c.length - 1 + i- b]  - c[i] < res) {
                res = c[c.length - 1 + i - b] - c[i] ;
            }
        }
        return  res;

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String[] s3 = s1.split(" ");
        String s2 = scanner.nextLine();
        int a  = Integer.parseInt(s3[0]);
        int b  = Integer.parseInt(s3[1]);
        long[] c = Arrays.stream(s2.split(" ")).mapToLong(Long::parseLong).toArray();
        System.out.println(dif(a, b, c));


    }
}
