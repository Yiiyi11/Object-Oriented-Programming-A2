import java.util.Queue;
import java.util.LinkedList;

public class Ride implements RideInterface {
    // Instance variables (Name, Type, Maximum Riders, Operator)
    private String rideName;
    private String rideType; // e.g., "Roller Coaster", "Water Ride"
    private Employee operator; // Must be of Employee type to identify if there is an operator
    private int maxRider;
    private int numOfCycles;

    private Queue<Visitor> waitingLine; // Waiting queue
    private LinkedList<Visitor> rideHistory; // Ride history records

    // Default constructor
    public Ride() {
        this.waitingLine = new LinkedList<>(); // Initialize queue
        this.rideHistory = new LinkedList<>(); // Initialize ride history
        this.numOfCycles = 0; // Default number of cycles is 0
    }

    // Parameterized constructor
    public Ride(String rideName, String rideType, Employee operator, int maxRider) {
        this(); // Call default constructor to initialize collections
        this.rideName = rideName;
        this.rideType = rideType;
        this.operator = operator;
        this.maxRider = maxRider;
    }

    // Getters and Setters
    public String getRideName() { return rideName; }
    public void setRideName(String rideName) { this.rideName = rideName; }
    public String getRideType() { return rideType; }
    public void setRideType(String rideType) { this.rideType = rideType; }
    public Employee getOperator() { return operator; }
    public void setOperator(Employee operator) { this.operator = operator; }
    public int getMaxRider() { return maxRider; }
    public void setMaxRider(int maxRider) { this.maxRider = maxRider; }
    public int getNumOfCycles() { return numOfCycles; }
    public void setNumOfCycles(int numOfCycles) { this.numOfCycles = numOfCycles; }

    // Override toString method
    @Override
    public String toString() {
        return "Ride{" +
                "rideName='" + rideName + '\'' +
                ", rideType='" + rideType + '\'' +
                ", operator=" + operator +
                ", maxRider=" + maxRider +
                ", numOfCycles=" + numOfCycles +
                '}';
    }

    @Override
    public void addVisitorToQueue(Visitor visitor) {
        if (visitor != null) {
            waitingLine.offer(visitor); // Use Queue's offer method to add elements (FIFO)
            System.out.println("Successfully added visitor " + visitor.getVisitorId() + " to " + rideName + " waiting queue");
        } else {
            System.out.println("Error: Visitor object is null, cannot add to queue");
        }
    }

    @Override
    public void removeVisitorFromQueue() {
        if (waitingLine.isEmpty()) {
            System.out.println("Error: " + rideName + " waiting queue is empty, cannot remove visitor");
            return;
        }
        Visitor removed = waitingLine.poll(); // Remove the head element of the queue
        System.out.println("Successfully removed visitor from " + rideName + " queue: " + removed.getVisitorId());
    }

    @Override
    public void printQueue() {
        if (waitingLine.isEmpty()) {
            System.out.println(rideName + " waiting queue is empty");
            return;
        }
        System.out.println("\n" + rideName + " Waiting Queue (Total: " + waitingLine.size() + " people):");
        int index = 1;
        for (Visitor visitor : waitingLine) {
            System.out.println(index + ". " + visitor);
            index++;
        }
    }

    @Override
    public void addVisitorToHistory(Visitor visitor) {
        // Part4: Add visitor to ride history
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        // Part4: Check if visitor exists in ride history
        return false;
    }

    @Override
    public int numberOfVisitors() {
        // Part4: Return number of visitors in history
        return 0;
    }

    @Override
    public void printRideHistory() {
        // Part4: Print ride history
    }

    @Override
    public void runOneCycle() {
        // Part5: Run one cycle of the ride
    }
}