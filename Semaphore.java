package hospitalsimulation;


public class Semaphore {
    private int value;
    
    public Semaphore(int value) {
        this.value = value;
    }
    
    public synchronized void acquire() throws InterruptedException {
        while (value <= 0) {
            wait();
        }
        value--;
    }

    public synchronized void release() {
        value++;
        notify();
    }
    
    public synchronized boolean tryToAcquire(long time) throws InterruptedException {
        long endTime = System.currentTimeMillis() + time;
        
        while (value <= 0) {
            long timeLeft = endTime - System.currentTimeMillis();
            
            if (timeLeft <= 0) return false;
            
            wait(timeLeft);
        }
        
        value--;
        return true;
    }
}
