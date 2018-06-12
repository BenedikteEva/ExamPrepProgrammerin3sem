/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fibonaccipackage;

import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ejer
 */
public class FibonacciProducer implements Runnable {

    // det array af tal vi starter med kommer herind
    BlockingQueue<Integer> numbersToMakeFibsFrom;
    // de fib tal der bliver lavet ryger herind
    BlockingQueue<Long> fibbonacciNumbersProduced;
    // denne skal vise at der stadig er noget i det første array
    public static volatile boolean notFinishedYet = true;

    public FibonacciProducer(BlockingQueue<Integer> numbersToMakeFibsFrom, BlockingQueue<Long> fibbonacciNumbersProduced) {
        this.numbersToMakeFibsFrom = numbersToMakeFibsFrom;
        this.fibbonacciNumbersProduced = fibbonacciNumbersProduced;
    }

    @Override
    public void run() {

        while (notFinishedYet) {
            try {
                Integer numberToUse = numbersToMakeFibsFrom.take();
                if (numberToUse == null) {
                    notFinishedYet = false;
                } else {
                    Long fibNumber = fib(numberToUse);
                    //Skal castes til Integer
                    Integer fibboInt = (int) (long) fibNumber;

                    Long fibboNumber = fib(numberToUse);
                    fibbonacciNumbersProduced.put(fibboNumber);
                }
            } catch (InterruptedException ex) {
                System.out.println("ProducerProblem ved run");
            }
        }
    }

    private long fib(long n) {
        if (n == 0 || n == 1) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

}
