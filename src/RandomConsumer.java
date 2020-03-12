import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Consumes integers from queue
 */

public class RandomConsumer implements Runnable {

    private final BlockingQueue<Integer> randomQueue;

    public RandomConsumer(BlockingQueue<Integer> randomQueue) {
        this.randomQueue = randomQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                randomQueue.take();
                TimeUnit.MILLISECONDS.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
