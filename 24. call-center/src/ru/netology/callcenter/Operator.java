package ru.netology.callcenter;

public class Operator implements Runnable {
    private final CallCenter callCenter;
    private final long CALL_PROCESSING_TIME = 3000;
    private final int THRESHOLD;


    public Operator(CallCenter callCenter, int threshold) {
        this.callCenter = callCenter;
        THRESHOLD = threshold;
    }

    @Override
    public void run() {
        try {
            while (THRESHOLD > callCenter.getCountProcessedCalls()) {
                String callProcessing = callCenter.callProcessing();
                if (callProcessing == null) {
                    continue;
                }
                Thread.sleep(CALL_PROCESSING_TIME);
                System.out.printf("%s обработал номер: %s\n"
                        , Thread.currentThread().getName()
                        , callProcessing);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
