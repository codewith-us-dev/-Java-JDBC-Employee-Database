import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class DB_Employee {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/employee_db"; 
        String user = "root"; 
        String password = "Tiger"; 

        try (Connection con = DriverManager.getConnection(url, user, password);
             Scanner sc = new Scanner(System.in)) {

            System.out.println("Connection Successful!");
            EmployeeAccess ea = new EmployeeAccess(con);
            int choice;

            do {
                System.out.println("======== Employee Management =======");
                System.out.println("1. Add an Employee");
                System.out.println("2. View Employees");
                System.out.println("3. Update an Employee");
                System.out.println("4. Delete an Employee");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();
                sc.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Department: ");
                        String dept = sc.nextLine();
                        System.out.print("Enter Salary: ");
                        double salary = sc.nextDouble();
                        ea.addEmployee(new Employee(id, name, dept, salary));
                        break;

                    case 2:
                        for (Employee e : ea.viewEmployee()) {
                            System.out.println(e);
                        }
                        break;

                    case 3:
                        System.out.print("Enter ID of employee to update: ");
                        id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter New Name: ");
                        name = sc.nextLine();
                        System.out.print("Enter New Department: ");
                        dept = sc.nextLine();
                        System.out.print("Enter New Salary: ");
                        salary = sc.nextDouble();
                        ea.updateEmployee(id, new Employee(id, name, dept, salary));
                        break;

                    case 4:
                        System.out.print("Enter ID of employee to delete: ");
                        id = sc.nextInt();
                        ea.deleteEmployee(id);
                        break;

                    case 5:
                        System.out.println("Exiting...");
                        break;

                    default:
                        System.out.println("Invalid Choice!");
                }
            } while (choice != 5);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
