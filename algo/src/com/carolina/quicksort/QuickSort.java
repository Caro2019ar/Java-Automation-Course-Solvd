package com.carolina.quicksort;

import com.carolina.model.Grade;

import java.util.Arrays;

public class QuickSort {

    public static void initial(Grade[] args) {
        sort(args, 0, args.length);
        Arrays.stream(args).map(grade -> grade.getName() + " " + grade.getValue()).forEach(System.out::println);
    }

    private static void sort(Grade[] grades, int from, int until) {
        int qtde = until - from;
        if (qtde > 1) {
            int pivotPosition = particiona(grades, from, until);
            sort(grades, from, pivotPosition);
            sort(grades, pivotPosition + 1, until);
        }
    }

    private static int particiona(Grade[] grades, int initial, int end) {
        int lowerFound = 0;
        Grade pivo = grades[end - 1];

        for (int analyzing = 0; analyzing < end - 1; analyzing++) {
            Grade actual = grades[analyzing];
            if (actual.getValue() <= pivo.getValue()) {
                swap(grades, analyzing, lowerFound);
                lowerFound++;
            }
        }
        swap(grades, end - 1, lowerFound);
        return lowerFound;
    }

    private static void swap(Grade[] grades, int from, int to) {
        Grade grade1 = grades[from];
        Grade grade2 = grades[to];
        grades[to] = grade1;
        grades[from] = grade2;
    }
}
