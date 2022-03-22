package com.carolina.quicksort;

import com.carolina.model.Grade;

public class QuickSort {

    public static void initial(Grade[] grades) {
        sort(grades, 0, grades.length);
        for (int actual = 0; actual < grades.length; actual++) {
            Grade grade = grades[actual];
            System.out.println(grade.getName() + " " + grade.getValue());
        }
    }

    private static void sort(Grade[] args, int from, int until) {
        int qtde = until - from;
        if (qtde > 1) {
            int pivotPosition = particiona(args, from, until);
            sort(args, from, pivotPosition);
            sort(args, pivotPosition + 1, until);
        }
    }

    private static int particiona(Grade[] args, int initial, int end) {
        int lowerFound = 0;
        Grade pivo = args[end - 1];

        for (int analyzing = 0; analyzing < end - 1; analyzing++) {
            Grade actual = args[analyzing];
            if (actual.getValue() <= pivo.getValue()) {
                swap(args, analyzing, lowerFound);
                lowerFound++;
            }
        }
        swap(args, end - 1, lowerFound);
        return lowerFound;
    }

    private static void swap(Grade[] args, int from, int to) {
        Grade grade1 = args[from];
        Grade grade2 = args[to];
        args[to] = grade1;
        args[from] = grade2;
    }
}
