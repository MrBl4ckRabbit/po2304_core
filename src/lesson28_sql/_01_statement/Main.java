package lesson28_sql._01_statement;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
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

            var query = "INSERT INTO staff(name,age,department,project) VALUES ('Employee11',27,5,3)";
            st.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
