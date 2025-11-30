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
        System.out.println("=== Part 3: 等待队列测试 ===");
        // 1. Create an operator
        Employee operator = new Employee("张三", 30, "13800138000", "EMP001", "过山车操作员");

        // 2. Create a Ride object
        Ride rollerCoaster = new Ride("过山车", "Roller Coaster", operator, 2);

        // 3. Create 5 visitors
        Visitor v1 = new Visitor("Jack", 25, "13900139001", "VIS001", true);
        Visitor v2 = new Visitor("Sharon", 22, "13900139002", "VIS002", false);
        Visitor v3 = new Visitor("Benny", 30, "13900139003", "VIS003", true);
        Visitor v4 = new Visitor("Leo", 18, "13900139004", "VIS004", false);
        Visitor v5 = new Visitor("Lily", 28, "13900139005", "VIS005", true);

        // 4. Add a guest to the queue
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
        System.out.println("\n移除1个访客后：");
        rollerCoaster.printQueue();
    }

    public void partFourA() {
        System.out.println("\n=== Part 4A: 乘坐历史测试 ===");
        // 1. Create a Ride object
        Ride thunderstorm = new Ride("雷暴", "Water Ride", new Employee("李四", 28, "13800138001", "EMP002", "水上项目操作员"), 4);

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
        System.out.println("\n访客 " + checkV.getVisitorId() + " 是否乘坐过？" + thunderstorm.checkVisitorFromHistory(checkV));

        // 5. Number of print history
        System.out.println("乘坐历史总人数：" + thunderstorm.numberOfVisitors());

        // 6. Print the full history
        thunderstorm.printRideHistory();
    }

    public void partFourB() {
        System.out.println("\n=== Part 4B: 历史记录排序测试 ===");
        // 1. Create a Ride object
        Ride ferrisWheel = new Ride("摩天轮", "Family Ride", new Employee("王五", 35, "13800138002", "EMP003", "摩天轮操作员"), 6);

        // 2. Create 5 visitors (age and fast pass random)
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
        System.out.println("\n排序前：");
        ferrisWheel.printRideHistory();

        // 5. Sorting
        ferrisWheel.sortRideHistory();

        // 6. Print after sorting
        System.out.println("\n排序后（年龄升序，同年龄有快速通行证在前）：");
        ferrisWheel.printRideHistory();
    }
    public void partFive() {
        System.out.println("\n=== Part 5: 运行Ride周期测试 ===");
        // 1. Create an operator
        Employee operator = new Employee("赵六", 33, "13800138003", "EMP004", "过山车操作员");

        // 2. Create a Ride object（maxRider=2）
        Ride rollerCoaster = new Ride("极速过山车", "Roller Coaster", operator, 2);

        // 3. Add 10 visitors to the queue
        for (int i = 1; i <= 10; i++) {
            Visitor v = new Visitor("Visitor" + i, 18 + i, "13900139" + (100 + i), "VIS" + (100 + i), i % 3 == 0);
            rollerCoaster.addVisitorToQueue(v);
        }

        // 4. Print queue before running
        System.out.println("\n运行前队列：");
        rollerCoaster.printQueue();

        // 5. Run a cycle
        rollerCoaster.runOneCycle();

        // 6. Print the queue and history after running
        System.out.println("\n运行后队列：");
        rollerCoaster.printQueue();
        System.out.println("\n运行后乘坐历史：");
        rollerCoaster.printRideHistory();
    }
    public void partSix() {
        System.out.println("\n=== Part 6: 导出乘坐历史到文件 ===");
        // 1. Create a Ride object and add 5 visitors to the history
        Ride logFlume = new Ride("激流勇进", "Water Ride", new Employee("孙七", 29, "13800138004", "EMP005", "水上项目操作员"), 3);
        logFlume.addVisitorToHistory(new Visitor("Frank", 27, "13900139021", "VIS021", true));
        logFlume.addVisitorToHistory(new Visitor("Grace", 23, "13900139022", "VIS022", false));
        logFlume.addVisitorToHistory(new Visitor("Henry", 31, "13900139023", "VIS023", true));
        logFlume.addVisitorToHistory(new Visitor("Ivy", 25, "13900139024", "VIS024", false));
        logFlume.addVisitorToHistory(new Visitor("Jack", 28, "13900139025", "VIS025", true));

        // 2. Export to CSV file (path can be customized, like rideHistory.csv in the project root)
        String filePath = "rideHistory.csv";
        logFlume.exportRideHistory(filePath);
    }
    public void partSeven() {
        System.out.println("\n=== Part 7: 从文件导入乘坐历史 ===");
        // 1. Create a Ride object
        Ride logFlume = new Ride("激流勇进", "Water Ride", new Employee("孙七", 29, "13800138004", "EMP005", "水上项目操作员"), 3);

        // 2. Import the CSV file generated by Part 6
        String filePath = "rideHistory.csv";
        logFlume.importRideHistory(filePath);

        // 3. Validate the import results
        System.out.println("\n导入后总人数：" + logFlume.numberOfVisitors());
        System.out.println("导入后历史记录：");
        logFlume.printRideHistory();
    }
}
