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
    public void partFourA() {}
    public void partFourB() {}
    public void partFive() {}
    public void partSix() {}
    public void partSeven() {}
}