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
    public void partFourB() {}
    public void partFive() {}
    public void partSix() {}
    public void partSeven() {}
}