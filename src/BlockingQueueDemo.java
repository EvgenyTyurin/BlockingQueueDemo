/**
 * Producer -> Consumer concurrency pattern demo
 * using BlockingQueue
 */

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueDemo {

    public static void main(String[] args) {
        // Queue of random integers
        BlockingQueue<Integer> randomQueue = new LinkedBlockingQueue<>(5);
        ExecutorService exec = Executors.newCachedThreadPool();
        // Run integers producer
        exec.execute(new RandomGenerator(randomQueue));
        // Run integers consumer
        exec.execute(new RandomConsumer(randomQueue));
    }

}
