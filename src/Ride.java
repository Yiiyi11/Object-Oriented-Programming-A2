import java.util.Queue;
import java.util.LinkedList;

public class Ride implements RideInterface {
    // 实例变量（名称、类型、最大载客量、操作员）
    private String rideName;
    private String rideType; // 如"Roller Coaster"、"Water Ride"
    private Employee operator; // 必须为Employee类型，标识是否有操作员
    private int maxRider;
    private int numOfCycles;

    private Queue<Visitor> waitingLine; // 等待队列
    private LinkedList<Visitor> rideHistory; // 乘坐历史

    public Ride() {
        this.waitingLine = new LinkedList<>(); // 初始化队列
        this.rideHistory = new LinkedList<>(); // 初始化历史记录
        this.numOfCycles = 0; // 默认运行次数为0
    }

    public Ride(String rideName, String rideType, Employee operator, int maxRider) {
        this(); // 调用默认构造器初始化集合
        this.rideName = rideName;
        this.rideType = rideType;
        this.operator = operator;
        this.maxRider = maxRider;
    }

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
        // Part3补充：添加访客到等待队列
    }

    @Override
    public void removeVisitorFromQueue() {
        // Part3补充：从队列移除访客
    }

    @Override
    public void printQueue() {
        // Part3补充：打印等待队列
    }

    @Override
    public void addVisitorToHistory(Visitor visitor) {
        // Part4补充：添加访客到乘坐历史
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        // Part4补充：检查访客是否在历史中
        return false;
    }

    @Override
    public int numberOfVisitors() {
        // Part4补充：返回历史记录中的访客数
        return 0;
    }

    @Override
    public void printRideHistory() {
        // Part4补充：打印乘坐历史
    }

    @Override
    public void runOneCycle() {
        // Part5补充：运行一次游乐设施周期
    }
}