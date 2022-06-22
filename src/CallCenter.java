import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class CallCenter {

    public Queue<String> queue = new ConcurrentLinkedQueue<>();

    public void workATC() {
        try {
            for (int i = 1; i <= (12); i++) {
                String call = "request " + i;
                queue.add(call);
                System.out.printf("%s added to queue ATC %s\n", Thread.currentThread().getName(), call);
                Thread.sleep(250);
                System.out.println(queue.size());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void workOperator() {
        try {
            Thread.sleep(1000);
            while (!queue.isEmpty()) {
                String call = queue.poll();
                if (call!=null) {
                    System.out.printf("%s has worked with %s\n", Thread.currentThread().getName(), call);
                    System.out.printf("%d requests has left \n", queue.size());

                }
                Thread.sleep(3000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}