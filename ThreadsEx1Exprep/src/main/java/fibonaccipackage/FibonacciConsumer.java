/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fibonaccipackage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

/**
 *
 * @author Ejer
 */
public class FibonacciConsumer implements Runnable {

    int fibonnacciTotal;
    List<Integer> fibonacciNumbersFromProducer = new ArrayList();
    ArrayBlockingQueue<Long> producedNumbers;
    private volatile boolean isThereMoreToConsume = true;

    public FibonacciConsumer(ArrayBlockingQueue<Long> producedNumbers) {
        this.producedNumbers = producedNumbers;
    }

    @Override
    public void run() {
        Long fibboNumber;

        while (isThereMoreToConsume) {
            try {
                //Stopper programmet for tidligt så ændre timeouten
                fibboNumber = (long) producedNumbers.take();
                if (fibboNumber == null) {
                    isThereMoreToConsume = false;
                } else {
                    System.out.println("Fibernacci number is: " + fibboNumber);
                    fibonnacciTotal += fibboNumber;
                    //System.out.println("Totalsummen er " + totalFibSum);//Hvis der skal printes subtotal

                }
            } catch (InterruptedException e) {
                System.out.println("consumer fejl!");
            }
        }
    }

    public int getTotalFibSum() {
        return fibonnacciTotal;
    }

}
