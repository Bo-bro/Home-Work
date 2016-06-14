//import org.junit.Assert;
//import org.junit.Test;
//
//import java.sql.*;
//
//public class JDBCTest {
//
//    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
//    static final String DB_URL = "jdbc:mysql://localhost:3306/TestDB?useSSL=false&useEncoding=true&characterEncoding=UTF-8";
//    static final String USER = "root";
//    static final String PASS = "toor";
//
//    @Test
//    public void testConnection() throws SQLException {
//        Connection conn = null;
//        try {
//            //Register JDBC driver
//            Class.forName("com.mysql.jdbc.Driver");
//
//            System.out.println("Connecting to database...");
//            conn = DriverManager.getConnection(DB_URL, USER, PASS);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        Assert.assertNotNull(conn);
//
//        Statement statement = conn.createStatement();
//
//        ResultSet resultSet =
//                statement.executeQuery("SELECT * FROM ORDERS;");
//        while (resultSet.next()){
//            int qty = resultSet.getInt("QTY");
//            System.out.println("QTY = " + qty);
//            break;
//        }
//        resultSet.close();
//        statement.close();
//        conn.close();
//    }
//}
