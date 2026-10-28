package hospitalsimulation;

public class TreatmentRooms {
    private Semaphore rooms;

    public TreatmentRooms() {
        rooms = new Semaphore(2); 
    }

    public boolean tryAcquireRoom() throws InterruptedException {
        return rooms.tryToAcquire(3000); 
    }

    public void releaseRoom() {
        rooms.release(); 
    }
}