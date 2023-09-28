package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class AbiturientsTask {
    static void solveTask() {
        Scanner scanner = new Scanner(System.in);
        int countAbitur = scanner.nextInt();
        int countOfPrograms = scanner.nextInt();
        int[] arrOfCountPlacesOfPrograms = new int[countOfPrograms];
        for (int i = 0; i < countOfPrograms; i++) {
            arrOfCountPlacesOfPrograms[i] = scanner.nextInt();
        }
        scanner.nextLine();


        List<AbiturPriority> listOfAbiturs = new ArrayList<>();

        int countNumber = 0;
        for (int i = 0; i < countAbitur; i++) {

            int rating;
            int countOfProgramsWhichHeWant;
            int[] programs;
            String str = scanner.nextLine();
            String[] arrStr = str.split(" ");
            rating = Integer.parseInt(arrStr[0]);
            countOfProgramsWhichHeWant = Integer.parseInt(arrStr[1]);
            programs = new int[countOfProgramsWhichHeWant];
            for (int j = 0; j < countOfProgramsWhichHeWant; j++) {
                programs[j] = Integer.parseInt(arrStr[j + 2]);
            }
            listOfAbiturs.add(new AbiturPriority(countNumber++, rating, countOfProgramsWhichHeWant, programs));


        }

        listOfAbiturs.sort((Comparator.comparingInt(AbiturPriority::getRating)));

        int[] results = new int[countAbitur];
        while (!listOfAbiturs.isEmpty()) {
            boolean flag = false;
            for (int i = 0; i < listOfAbiturs.get(0).programs.length; i++) {
                if(arrOfCountPlacesOfPrograms[listOfAbiturs.get(0).programs[i] -1] > 0) {
                    arrOfCountPlacesOfPrograms[listOfAbiturs.get(0).programs[i] -1]--;
                    results[listOfAbiturs.get(0).getCountNumber()] = listOfAbiturs.get(0).programs[i];
                    break;
                }
                else {
                    results[listOfAbiturs.get(0).getCountNumber()] = -1;
                }
            }
            listOfAbiturs.remove(0);
        }
       String s = "";
        for (int i = 0; i < results.length; i++) {
            s += results[i] + " ";
        }
        System.out.println(s.trim());

    }

    public static void main(String[] args) {

        solveTask();
    }

    static class AbiturPriority {
        int countNumber;
        int rating;
        int countOfProgramsWhichHeWant;
        int[] programs;

        public int getCountNumber() {
            return countNumber;
        }

        public void setCountNumber(int countNumber) {
            this.countNumber = countNumber;
        }

        public int getCountOfProgramsWhichHeWant() {
            return countOfProgramsWhichHeWant;
        }

        public void setCountOfProgramsWhichHeWant(int countOfProgramsWhichHeWant) {
            this.countOfProgramsWhichHeWant = countOfProgramsWhichHeWant;
        }

        public AbiturPriority(int countNumber, int rating, int countOfProgramsWhichHeWant, int[] programs) {
            this.countNumber = countNumber;
            this.rating = rating;
            this.countOfProgramsWhichHeWant = countOfProgramsWhichHeWant;
            this.programs = programs;
        }

        public int getRating() {
            return rating;
        }

        public void setRating(int rating) {
            this.rating = rating;
        }

        public int getCountOfPrograms() {
            return countOfProgramsWhichHeWant;
        }

        public void setCountOfPrograms(int countOfPrograms) {
            this.countOfProgramsWhichHeWant = countOfPrograms;
        }

        public int[] getPrograms() {
            return programs;
        }

        public void setPrograms(int[] programs) {
            this.programs = programs;
        }

    }


}
