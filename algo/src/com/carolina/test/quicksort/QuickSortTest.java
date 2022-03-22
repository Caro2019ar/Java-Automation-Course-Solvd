package com.carolina.test.quicksort;

import com.carolina.model.Grade;
import com.carolina.quicksort.QuickSort;

public class QuickSortTest {

    public static void main(String[] args) {

        Grade[] gradesExample = {
                new Grade("anny", 4),
                new Grade("andy", 5),
                new Grade("charles", 8.5),
                new Grade("paul", 9),
                new Grade("john", 3),
                new Grade("july", 6.7),
                new Grade("lucy", 9.3),
                new Grade("anne", 10),
                new Grade("gilbert", 7),

        };
        QuickSort.initial(gradesExample);

    }

}
