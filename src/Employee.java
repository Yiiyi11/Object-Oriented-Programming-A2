public class Employee extends Person {
    // 专属实例变量（员工ID、负责岗位）
    private String employeeId;
    private String position;

    public Employee() {}

    public Employee(String name, int age, String contactNumber, String employeeId, String position) {
        super(name, age, contactNumber); // 调用父类构造器
        this.employeeId = employeeId;
        this.position = position;
    }

    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }
    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }

    @Override
    public String toString() {
        return "Employee{employeeId='" + employeeId + "', position='" + position + "', " + super.toString() + "}";
    }
}