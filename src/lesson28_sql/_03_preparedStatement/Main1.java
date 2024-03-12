package lesson28_sql._03_preparedStatement;

import lesson28_sql._02_statement_select.Employee;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main1 {
    public static final String URL = "jdbc:mysql://localhost:3306/po_2304";
    public static final String USER = "root";
    public static final String Password = "";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try (var cn = DriverManager.getConnection(URL, USER, Password);
             var st = cn.createStatement()) {
            var staff = new ArrayList<Employee>();
            var query = String.format("Select name,age,department From staff Where age > %d And name Like '%s'", 20, "Emp%");
            var rs = st.executeQuery(query);
            while (rs.next()) {
                var name = rs.getString(1);
                var age = rs.getInt("age");
                var department = rs.getInt(3);
                staff.add(new Employee(name, age, department));
            }
            staff.forEach(System.out::println);
            st.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
