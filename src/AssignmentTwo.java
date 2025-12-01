public class AssignmentTwo {
    public static void main(String[] args) {
        AssignmentTwo assignment = new AssignmentTwo();
        assignment.partThree();
        assignment.partFourA();
        assignment.partFourB();
        assignment.partFive();
        assignment.partSix();
        assignment.partSeven();
    }

    public void partThree() {
        System.out.println("=== Part 3: Waiting Queue Test ===");
        // 1. Create an operator
        Employee operator = new Employee("Zhang San", 30, "13800138000", "EMP001", "Roller Coaster Operator");

        // 2. Create a Ride object
        Ride rollerCoaster = new Ride("Roller Coaster", "Thrill Ride", operator, 2);

        // 3. Create 5 visitors
        Visitor v1 = new Visitor("Jack", 25, "13900139001", "VIS001", true);
        Visitor v2 = new Visitor("Sharon", 22, "13900139002", "VIS002", false);
        Visitor v3 = new Visitor("Benny", 30, "13900139003", "VIS003", true);
        Visitor v4 = new Visitor("Leo", 18, "13900139004", "VIS004", false);
        Visitor v5 = new Visitor("Lily", 28, "13900139005", "VIS005", true);

        // 4. Add visitors to the queue
        rollerCoaster.addVisitorToQueue(v1);
        rollerCoaster.addVisitorToQueue(v2);
        rollerCoaster.addVisitorToQueue(v3);
        rollerCoaster.addVisitorToQueue(v4);
        rollerCoaster.addVisitorToQueue(v5);

        // 5. Print queue
        rollerCoaster.printQueue();

        // 6. Remove 1 visitor
        rollerCoaster.removeVisitorFromQueue();

        // 7. Print the queue again
        System.out.println("\nAfter removing 1 visitor:");
        rollerCoaster.printQueue();
    }

    public void partFourA() {
        System.out.println("\n=== Part 4A: Ride History Test ===");
        // 1. Create a Ride object
        Ride thunderstorm = new Ride("Thunderstorm", "Water Ride", new Employee("Li Si", 28, "13800138001", "EMP002", "Water Ride Operator"), 4);

        // 2. Create 5 visitors
        Visitor v1 = new Visitor("Tom", 24, "13900139006", "VIS006", false);
        Visitor v2 = new Visitor("Sherly", 26, "13900139007", "VIS007", true);
        Visitor v3 = new Visitor("Ben", 32, "13900139008", "VIS008", false);
        Visitor v4 = new Visitor("David", 21, "13900139009", "VIS009", true);
        Visitor v5 = new Visitor("Emma", 29, "13900139010", "VIS010", false);

        // 3. Add to history
        thunderstorm.addVisitorToHistory(v1);
        thunderstorm.addVisitorToHistory(v2);
        thunderstorm.addVisitorToHistory(v3);
        thunderstorm.addVisitorToHistory(v4);
        thunderstorm.addVisitorToHistory(v5);

        // 4. Check if a visitor is in history
        Visitor checkV = new Visitor("Sherly", 26, "13900139007", "VIS007", true);
        System.out.println("\nHas visitor " + checkV.getVisitorId() + " ridden this ride? " + thunderstorm.checkVisitorFromHistory(checkV));

        // 5. Print total number of visitors in history
        System.out.println("Total visitors in ride history: " + thunderstorm.numberOfVisitors());

        // 6. Print the full history
        thunderstorm.printRideHistory();
    }

    public void partFourB() {
        System.out.println("\n=== Part 4B: Ride History Sorting Test ===");
        // 1. Create a Ride object
        Ride ferrisWheel = new Ride("Ferris Wheel", "Family Ride", new Employee("Wang Wu", 35, "13800138002", "EMP003", "Ferris Wheel Operator"), 6);

        // 2. Create 5 visitors (random age and fast pass status)
        Visitor v1 = new Visitor("Alice", 25, "13900139011", "VIS011", false);
        Visitor v2 = new Visitor("Bob", 22, "13900139012", "VIS012", true);
        Visitor v3 = new Visitor("Charlie", 25, "13900139013", "VIS013", true);
        Visitor v4 = new Visitor("Diana", 30, "13900139014", "VIS014", false);
        Visitor v5 = new Visitor("Ethan", 22, "13900139015", "VIS015", false);

        // 3. Add to history
        ferrisWheel.addVisitorToHistory(v1);
        ferrisWheel.addVisitorToHistory(v2);
        ferrisWheel.addVisitorToHistory(v3);
        ferrisWheel.addVisitorToHistory(v4);
        ferrisWheel.addVisitorToHistory(v5);

        // 4. Print before sorting
        System.out.println("\nBefore sorting:");
        ferrisWheel.printRideHistory();

        // 5. Sort the history
        ferrisWheel.sortRideHistory();

        // 6. Print after sorting
        System.out.println("\nAfter sorting (ascending by age, fast pass first for same age):");
        ferrisWheel.printRideHistory();
    }

    public void partFive() {
        System.out.println("\n=== Part 5: Ride Cycle Operation Test ===");
        // 1. Create an operator
        Employee operator = new Employee("Zhao Liu", 33, "13800138003", "EMP004", "Roller Coaster Operator");

        // 2. Create a Ride object (max riders per cycle = 2)
        Ride rollerCoaster = new Ride("Speed Coaster", "Thrill Ride", operator, 2);

        // 3. Add 10 visitors to the queue
        for (int i = 1; i <= 10; i++) {
            Visitor v = new Visitor("Visitor" + i, 18 + i, "13900139" + (100 + i), "VIS" + (100 + i), i % 3 == 0);
            rollerCoaster.addVisitorToQueue(v);
        }

        // 4. Print queue before running the cycle
        System.out.println("\nQueue before operation:");
        rollerCoaster.printQueue();

        // 5. Run one operation cycle
        rollerCoaster.runOneCycle();

        // 6. Print the queue and history after running
        System.out.println("\nQueue after operation:");
        rollerCoaster.printQueue();
        System.out.println("\nRide history after operation:");
        rollerCoaster.printRideHistory();
    }

    public void partSix() {
        System.out.println("\n=== Part 6: Export Ride History to File ===");
        // 1. Create a Ride object and add 5 visitors to the history
        Ride logFlume = new Ride("Log Flume", "Water Ride", new Employee("Sun Qi", 29, "13800138004", "EMP005", "Water Ride Operator"), 3);
        logFlume.addVisitorToHistory(new Visitor("Frank", 27, "13900139021", "VIS021", true));
        logFlume.addVisitorToHistory(new Visitor("Grace", 23, "13900139022", "VIS022", false));
        logFlume.addVisitorToHistory(new Visitor("Henry", 31, "13900139023", "VIS023", true));
        logFlume.addVisitorToHistory(new Visitor("Ivy", 25, "13900139024", "VIS024", false));
        logFlume.addVisitorToHistory(new Visitor("Jack", 28, "13900139025", "VIS025", true));

        // 2. Export to CSV file (path can be customized, e.g., rideHistory.csv in project root)
        String filePath = "rideHistory.csv";
        logFlume.exportRideHistory(filePath);
    }

    public void partSeven() {
        System.out.println("\n=== Part 7: Import Ride History from File ===");
        // 1. Create a Ride object
        Ride logFlume = new Ride("Log Flume", "Water Ride", new Employee("Sun Qi", 29, "13800138004", "EMP005", "Water Ride Operator"), 3);

        // 2. Import the CSV file generated by Part 6
        String filePath = "rideHistory.csv";
        logFlume.importRideHistory(filePath);

        // 3. Validate the import results
        System.out.println("\nTotal visitors after import: " + logFlume.numberOfVisitors());
        System.out.println("Ride history after import:");
        logFlume.printRideHistory();
    }
}