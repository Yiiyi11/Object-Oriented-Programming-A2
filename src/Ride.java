import java.util.Queue;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Collections;
// Add IO imports for CSV export (critical)
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ride implements RideInterface {
    // Instance variables (unchanged)
    private String rideName;
    private String rideType;
    private Employee operator;
    private int maxRider;
    private int numOfCycles;

    private Queue<Visitor> waitingLine;
    private LinkedList<Visitor> rideHistory;

    // Constructors (unchanged)
    public Ride() {
        this.waitingLine = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
        this.numOfCycles = 0;
    }

    public Ride(String rideName, String rideType, Employee operator, int maxRider) {
        this();
        this.rideName = rideName;
        this.rideType = rideType;
        this.operator = operator;
        this.maxRider = maxRider;
    }

    // Getters & Setters (unchanged)
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

    // toString() (unchanged)
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
    // Part 3: Queue-related methods (unchanged)
    // ------------------------------
    @Override
    public void addVisitorToQueue(Visitor visitor) {
        if (visitor != null) {
            waitingLine.offer(visitor);
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
        Visitor removed = waitingLine.poll();
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
    // Part 4A: Ride history-related methods (unchanged)
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
        Iterator<Visitor> iterator = rideHistory.iterator();
        while (iterator.hasNext()) {
            Visitor v = iterator.next();
            if (v.getVisitorId().equals(visitor.getVisitorId())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int numberOfVisitors() {
        return rideHistory.size();
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
    // Part 4B: Sort ride history (unchanged)
    // ------------------------------
    public void sortRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println(rideName + " ride history is empty - no need to sort");
            return;
        }
        Collections.sort(rideHistory, new VisitorComparator());
        System.out.println(rideName + " ride history sorted successfully");
    }

    // ------------------------------
    // Part 5: Run one cycle (unchanged)
    // ------------------------------
    @Override
    public void runOneCycle() {
        System.out.println("\n=== Starting one operation cycle for " + rideName + " ===");
        if (operator == null) {
            System.out.println("Error: No operator assigned to " + rideName + ", cannot start operation");
            return;
        }
        if (waitingLine.isEmpty()) {
            System.out.println("Error: " + rideName + " waiting queue is empty, cannot start operation");
            return;
        }

        int ridersThisCycle = Math.min(maxRider, waitingLine.size());
        System.out.println("Number of riders for this cycle: " + ridersThisCycle);

        for (int i = 0; i < ridersThisCycle; i++) {
            Visitor rider = waitingLine.poll();
            addVisitorToHistory(rider);
            System.out.println("Visitor " + rider.getVisitorId() + " has boarded the ride");
        }

        numOfCycles++;
        String ordinalSuffix = getOrdinalSuffix(numOfCycles);
        System.out.println(rideName + " completed its " + numOfCycles + ordinalSuffix + " operation cycle");
    }

    // Helper method for ordinal suffix (optional, for Part 5)
    private String getOrdinalSuffix(int number) {
        if (number % 100 >= 11 && number % 100 <= 13) {
            return "th";
        }
        return switch (number % 10) {
            case 1 -> "st";
            case 2 -> "nd";
            case 3 -> "rd";
            default -> "th";
        };
    }

    // ------------------------------
    // Extended Feature: Export ride history to CSV (ADD HERE)
    // ------------------------------

    public void exportRideHistory(String filePath) {
        System.out.println("\n=== Exporting " + rideName + " ride history to file ===");
        // Try-with-resources: Auto-close BufferedWriter to avoid resource leaks
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Write ride history in CSV format: VisitorID,Name,Age,ContactNumber,HasFastPass
            for (Visitor visitor : rideHistory) {
                String line = String.join(",",
                        visitor.getVisitorId(),
                        visitor.getName(),
                        String.valueOf(visitor.getAge()),
                        visitor.getContactNumber(),
                        String.valueOf(visitor.isHasFastPass())
                );
                writer.write(line);
                writer.newLine(); // New line for next record
            }
            System.out.println("Successfully exported " + rideHistory.size() + " records to " + filePath);
        } catch (IOException e) {
            System.out.println("Error: Failed to export file - " + e.getMessage());
        }
    }

    public void importRideHistory(String filePath) {
        System.out.println("\n=== Importing ride history to " + rideName + " from file ===");
        // Clear existing history (optional: remove this line to append instead of overwrite)
        rideHistory.clear();

        // Try-with-resources: Auto-close BufferedReader to avoid resource leaks
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int importedCount = 0;
            // Read CSV file line by line
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue; // Skip empty lines
                }
                // Split CSV line into fields (format: VisitorID,Name,Age,ContactNumber,HasFastPass)
                String[] fields = line.split(",");
                // Validate field count (must have exactly 5 fields)
                if (fields.length != 5) {
                    System.out.println("Warning: Skipping invalid line - " + line);
                    continue;
                }
                // Parse fields with type conversion validation
                String visitorId = fields[0];
                String name = fields[1];
                int age;
                boolean hasFastPass;
                try {
                    age = Integer.parseInt(fields[2]); // Parse age (integer)
                    hasFastPass = Boolean.parseBoolean(fields[4]); // Parse fast pass status (boolean)
                } catch (NumberFormatException e) {
                    System.out.println("Warning: Skipping line with format error - " + line + " (" + e.getMessage() + ")");
                    continue;
                }
                String contactNumber = fields[3];

                // Create Visitor object and add to ride history
                Visitor visitor = new Visitor(name, age, contactNumber, visitorId, hasFastPass);
                rideHistory.add(visitor);
                importedCount++;
            }
            System.out.println("Successfully imported " + importedCount + " records");
        } catch (IOException e) {
            System.out.println("Error: Failed to import file - " + e.getMessage());
        }
    }
}