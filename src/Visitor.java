public class Visitor extends Person {
    // 专属实例变量（访客ID、是否购买快速通行证）
    private String visitorId;
    private boolean hasFastPass;

    public Visitor() {}

    public Visitor(String name, int age, String contactNumber, String visitorId, boolean hasFastPass) {
        super(name, age, contactNumber);
        this.visitorId = visitorId;
        this.hasFastPass = hasFastPass;
    }

    public String getVisitorId() { return visitorId; }
    public void setVisitorId(String visitorId) { this.visitorId = visitorId; }
    public boolean isHasFastPass() { return hasFastPass; }
    public void setHasFastPass(boolean hasFastPass) { this.hasFastPass = hasFastPass; }

    @Override
    public String toString() {
        return "Visitor{visitorId='" + visitorId + "', hasFastPass=" + hasFastPass + ", " + super.toString() + "}";
    }
}