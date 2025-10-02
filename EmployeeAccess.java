import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeAccess {
    private Connection con;

    public EmployeeAccess(Connection con) {
        this.con = con;
    }

    public void addEmployee(Employee e) {
        String sql = "INSERT INTO employee(id, name, department, salary) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, e.getId());
            ps.setString(2, e.getName());
            ps.setString(3, e.getDept());
            ps.setDouble(4, e.getSal());
            ps.executeUpdate();
            System.out.println("Employee Added Successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Employee> viewEmployee() {
        List<Employee> list = new ArrayList<>();
        String sql = "SELECT * FROM employee";
        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Employee e = new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("department"),
                        rs.getDouble("salary")
                );
                list.add(e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void updateEmployee(int id, Employee e) {
        String sql = "UPDATE employee SET name = ?, department = ?, salary = ? WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, e.getName());
            ps.setString(2, e.getDept());
            ps.setDouble(3, e.getSal());
            ps.setInt(4, id);
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Employee Updated Successfully!");
            else
                System.out.println("Employee ID not found.");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteEmployee(int id) {
        String sql = "DELETE FROM employee WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Employee Deleted Successfully!");
            else
                System.out.println("Employee ID not found.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
