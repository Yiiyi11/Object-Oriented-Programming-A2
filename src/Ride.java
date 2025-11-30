import java.util.Queue;
import java.util.LinkedList;
import java.util.Iterator;

public class Ride implements RideInterface {
    // Instance variables (Name, Type, Maximum Riders, Operator)
    private String rideName;
    private String rideType; // e.g., "Roller Coaster", "Water Ride"
    private Employee operator; // Must be of Employee type to identify the assigned operator
    private int maxRider;
    private int numOfCycles;

    private Queue<Visitor> waitingLine; // Waiting queue (FIFO)
    private LinkedList<Visitor> rideHistory; // Ride history records

    // Default constructor
    public Ride() {
        this.waitingLine = new LinkedList<>(); // Initialize waiting queue
        this.rideHistory = new LinkedList<>(); // Initialize ride history
        this.numOfCycles = 0; // Default number of operation cycles is 0
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

    // ------------------------------
    // Queue-related method implementations (Part 3)
    // ------------------------------
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

    // ------------------------------
    // Ride history-related method implementations (Part 4A)
    // ------------------------------
    @Override
    public void addVisitorToHistory(Visitor visitor) {
        if (visitor != null) {
            rideHistory.add(visitor);
            System.out.println("Successfully added visitor " + visitor.getVisitorId() + " to " + rideName + " ride history");
        } else {
            System.out.println("Error: Visitor object is null, cannot add to ride history");
        }
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        if (visitor == null) {
            System.out.println("Error: Visitor object is null, cannot perform check");
            return false;
        }
        // Use Iterator to traverse (REQUIRED - no marks if not used)
        Iterator<Visitor> iterator = rideHistory.iterator();
        while (iterator.hasNext()) {
            Visitor v = iterator.next();
            if (v.getVisitorId().equals(visitor.getVisitorId())) { // Check by visitor ID
                return true;
            }
        }
        return false;
    }

    @Override
    public int numberOfVisitors() {
        return rideHistory.size(); // Return total number of visitors in history
    }

    @Override
    public void printRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println(rideName + " has no ride history yet");
            return;
        }
        System.out.println("\n" + rideName + " Ride History (Total: " + rideHistory.size() + " people):");
        Iterator<Visitor> iterator = rideHistory.iterator();
        int index = 1;
        while (iterator.hasNext()) {
            System.out.println(index + ". " + iterator.next());
            index++;
        }
    }
    // ------------------------------
    // Part 4B: Sort ride history using VisitorComparator
    // ------------------------------
    public void sortRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println(rideName + " ride history is empty - no need to sort");
            return;
        }
        // Use VisitorComparator to sort the LinkedList (age ascending → fast pass descending)
        Collections.sort(rideHistory, new VisitorComparator());
        System.out.println(rideName + " ride history sorted successfully");
    }
    @Override
    public void runOneCycle() {
        // Part5: Implement one operation cycle of the ride
    }
}