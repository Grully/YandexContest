package org.example;

import java.util.Scanner;

public class USBCounter {
    static long cost(long countExisting, long countNeeded, long costOne, long costFour) {
        if (countExisting >= countNeeded) {
            return 0;
        }
        long count = countNeeded - countExisting;
        long dif = count % 4;
        if (costOne < costFour / 4) {
            return count * costOne;
        }
        else {
            return (dif * costOne < costFour) ? ((count - dif)/ 4) * costFour + dif * costOne : ((count - dif)/ 4) + costFour;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long c = sc.nextLong();
        long d = sc.nextLong();
        System.out.println(cost(a, b, c, d));
    }
}