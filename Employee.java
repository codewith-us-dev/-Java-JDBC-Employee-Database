public class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary){
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDept() { return department; }
    public void setDept(String department) { this.department = department; }

    public double getSal() { return salary; }
    public void setSal(double salary) { this.salary = salary; }

    @Override
    public String toString() {
        return id + " | " + name + " | " + department + " | " + salary;
    }
}
