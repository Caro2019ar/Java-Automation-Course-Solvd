package br.caro.part3;

public class Connecting implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("Connecting to server... Thread Id: "+Thread.currentThread().getId());
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
