package br.caro.part3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Part3Main {
    public static void main(String[] args)  throws Exception{
        ExecutorService threadExec = Executors.newFixedThreadPool(5);
        Connecting connect1 = new Connecting();
        Connecting connect2 = new Connecting();
        Connecting connect3 = new Connecting();
        Connecting connect4 = new Connecting();
        Connecting connect5 = new Connecting();
        Connecting connect6 = new Connecting();
        Connecting connect7 = new Connecting();


        threadExec.execute(connect1);
        threadExec.execute(connect2);
        threadExec.execute(connect3);
        threadExec.execute(connect4);
        threadExec.execute(connect5);


        threadExec.execute(connect6);
        threadExec.execute(connect7);
        threadExec.shutdown();

    }
}
