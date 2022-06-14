public class Main {

    public static void main(String[] args) throws InterruptedException {

        CallCenter callCenter = new CallCenter();

        Thread atc = new Thread(callCenter::workATC, "АТС");

        Thread profy1 = new Thread(callCenter::workOperator, "Operator 1");

        Thread profy2 = new Thread(callCenter::workOperator, "Operator 2");

        Thread profy3 = new Thread(callCenter::workOperator, "Operator 3");



        profy1.start();
//        Thread.sleep(700);
        profy2.start();
//        Thread.sleep(800);
        profy3.start();
        atc.start();
        atc.join();
        profy1.join();
        profy2.join();
        profy2.join();

    }
}
