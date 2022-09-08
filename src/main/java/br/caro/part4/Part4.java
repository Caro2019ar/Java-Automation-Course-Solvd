package br.caro.part4;

import java.util.concurrent.*;

public class Part4 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ConnectRunnable connRun = new ConnectRunnable();
        CompletionStage<Void> compStage =
                CompletableFuture.runAsync(() -> System.out.println("running, in thread: "));
        compStage.thenRunAsync(connRun);
    }


}
