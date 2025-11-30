public class Ride implements RideInterface { // 后续Part 2实现接口，提前声明
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
        return "Ride{rideName='" + rideName + "', rideType='" + rideType + "', operator=" + operator + ", maxRider=" + maxRider + "}";
    }
}