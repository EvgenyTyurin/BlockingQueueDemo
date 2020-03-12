import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * Generates integer and puts it to queue
 */

public class RandomGenerator implements Runnable {

    private final BlockingQueue<Integer> randomQueue;

    public RandomGenerator(BlockingQueue<Integer> randomQueue) {
        this.randomQueue = randomQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                randomQueue.put(ThreadLocalRandom.current().nextInt());
                System.out.println("Queue size: " + randomQueue.size());
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
