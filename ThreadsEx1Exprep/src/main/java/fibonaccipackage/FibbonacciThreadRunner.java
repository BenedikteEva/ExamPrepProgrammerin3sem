package fibonaccipackage;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FibbonacciThreadRunner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        int numbersToProducesFibsFrom[] = {4, 5, 8, 12, 21, 22, 34, 35, 36, 37, 42};

        ArrayBlockingQueue<Integer> s1 = new ArrayBlockingQueue(12);
        for (int i = 0; i < numbersToProducesFibsFrom.length; i++) {
            s1.add(numbersToProducesFibsFrom[i]);
        }
        BlockingQueue<Long> producedFibs = new ArrayBlockingQueue(12);
        ExecutorService es = Executors.newCachedThreadPool();
        long startTime = System.nanoTime();
        executeNProducers(4, es, s1, producedFibs);
        int n = 4;
//        es.execute(new FibonacciProducer(s1, producedFibs));
//        es.execute(new FibonacciProducer(s1, producedFibs));
//        es.execute(new FibonacciProducer(s1, producedFibs));
//        es.execute(new FibonacciProducer(s1, producedFibs));
       
 long endTime = System.nanoTime();

        double diff = endTime - startTime;
        diff = diff / 1000000000;
        System.out.println("Time using " + n + " threads: " + diff + "seconds");
        //Laver en consumer og starter den
        FibonacciConsumer consumer = new FibonacciConsumer((ArrayBlockingQueue<Long>) producedFibs);
        es.execute(consumer);
 
        es.shutdown();

        try {
            es.awaitTermination(10L, TimeUnit.SECONDS);      

            System.out.println("Totalsummen er " + consumer.getTotalFibSum());
            System.out.println("Closing Down. Wait 10 secounds...");
            System.exit(0);
        } catch (InterruptedException e) {
            System.out.println("Fejl ved closing down i main" + e.getMessage());
        }

    }

    public static void executeNProducers(int n, ExecutorService es, ArrayBlockingQueue<Integer> s1, BlockingQueue<Long> producedFibs) {
        //Laver og starter de 4 producere. P1 til P4 istedet for fire tråde bruger jeg en executorservice

        for (int i = 0; i < n; i++) {
            es.execute(new FibonacciProducer(s1, producedFibs));
        }

    }
}
