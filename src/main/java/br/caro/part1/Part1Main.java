package br.caro.part1;

import br.caro.part1.model.DivideRunnable;
import br.caro.part1.model.MultiplyThread;

public class Part1Main {
    public static void main(String[] args) {
        MultiplyThread multi = new MultiplyThread();
        multi.start();
        DivideRunnable divide = new DivideRunnable();
        Thread threadDivide = new Thread(divide);
        threadDivide.start();
    }
}
