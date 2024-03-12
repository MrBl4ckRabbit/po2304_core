package lesson28_sql._03_preparedStatement;

import lesson28_sql._02_statement_select.Employee;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static final String URL = "jdbc:mysql://localhost:3306/po_2304";
    public static final String USER = "root";
    public static final String Password = "";

    public static void main(String[] args) {
        var query = "Select name,age,department From staff Where age > ? And name Like ?";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try (var cn = DriverManager.getConnection(URL, USER, Password); var ps = cn.prepareStatement(query)) {
            var staff = new ArrayList<Employee>();
            ps.setInt(1, 20);
            ps.setString(2,"Emp%");
            var rs = ps.executeQuery();
            while (rs.next()) {
                var name = rs.getString(1);
                var age = rs.getInt("age");
                var department = rs.getInt(3);
                staff.add(new Employee(name, age, department));
            }
            staff.forEach(System.out::println);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
