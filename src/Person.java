public abstract class Person { //abstract 关键字，将普通类转为抽象类
    // 实例变量（姓名、年龄、联系电话）
    private String name;
    private int age;
    private String contactNumber;

    // 默认构造器
    public Person() {}

    // 带参构造器
    public Person(String name, int age, String contactNumber) {
        this.name = name;
        this.age = age;
        this.contactNumber = contactNumber;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getContactNumber() { return contactNumber; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + ", contactNumber='" + contactNumber + "'}";
    }
}