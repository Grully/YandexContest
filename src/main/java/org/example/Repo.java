package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Repo {

    static int counter(int[] arr, int index) {
        int result = 1;
        if (arr[index] == 0) {
            return result;
        } else {
            return result + counter(arr, arr[index] - 1);
        }
    }

    static int maxResult(int[] arr) {
        int result = 0;
        int ret = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int temp = counter(arr, i);
            if (temp > result) {
                result = temp;
                ret = i;
            }
        }
        return ++ret;
    }

    static void task() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n+1; i++) {
            list.add(0);
        }


        for (int i = 1; i < n+1; i++) {
            list.set(i, list.get(scanner.nextInt()) + 1);
        }
        int max = 0;
        int result = 0;
        for (int i = 0; i < n+1; i++) {
            if (list.get(i) > max) {
                max = list.get(i);
                result = i;
            }
        }

        System.out.println(result);


    }

    public static void main(String[] args) {
        task();
    }

}
