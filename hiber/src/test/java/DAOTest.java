//import org.demo.helpers.ConnectionToDB;
//import org.demo.dao.OfficeDao;
//import org.demo.models.Office;
//import org.junit.Assert;
//import org.junit.Test;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.util.List;
//
///**
// * Created by nikolay on 5/24/16.
// */
//public class DAOTest {
//
//    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
//    static final String DB_URL = "jdbc:mysql://localhost:3306/TestDB?useSSL=false&useEncoding=true&characterEncoding=UTF-8";
//    static final String USER = "root";
//    static final String PASS = "toor";
//
//    @Test
//   public void testConnection() throws SQLException {
////        Connection conn = null;
////        try {
////            //Register JDBC driver
////            Class.forName("com.mysql.jdbc.Driver");
////
////            System.out.println("Connecting to database...");
////            conn = DriverManager.getConnection(DB_URL, USER, PASS);
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
//            Connection conn = ConnectionToDB.getInstance();
//
//        Assert.assertNotNull(conn);
//        System.out.println("Assert.assertNotNull");
//
//        OfficeDao officeDao = new OfficeDao(conn);
//        List<Office> all = officeDao.getAll();
//        Assert.assertTrue(all.size() > 0);
//        System.out.println("Assert.assertTrue(all.size() > 0)");
//
//        conn.close();
//    }
//}
