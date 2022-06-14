import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class CallCenter {

    public Queue<String> queue = new ConcurrentLinkedQueue<>();

    int iterations = 0;

    public void workATC() {
        try {
            for (int i = 1; i <= (12); i++) {
                String call = "request " + i;
                queue.add(call);
                System.out.printf("%s added to queue ATC %s\n", Thread.currentThread().getName(), call);
            }
            iterations++;
            Thread.sleep(3350);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void workOperator() {
        try {
            Thread.sleep(3000);
            while (true) {
                if (queue.isEmpty()) {
                    break;
                } else {
                    System.out.printf("%s has worked with %s\n", Thread.currentThread().getName(), queue.poll());
                    System.out.printf("%d requests has left \n", queue.size());
                    Thread.sleep(3000);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
