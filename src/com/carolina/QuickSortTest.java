package com.carolina;

public class QuickSortTest {
        public static void main(String[] args) {
            Grade[] grades = {
                    new Grade("andre", 4),
                    new Grade("mariana", 5),
                    new Grade("carlos", 8.5),
                    new Grade("paulo", 9),
                    new Grade("jonas", 3),
                    new Grade("juliana", 6.7),
                    new Grade("lucia", 9.3),
                    new Grade("ana", 10),
                    new Grade("guilherme", 7),

            };

            sort(grades, 0, grades.length);
            for (int actual = 0; actual < grades.length; actual++) {
                Grade grade = grades[actual];
                System.out.println(grade.getName() + " " + grade.getValue());
            }
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