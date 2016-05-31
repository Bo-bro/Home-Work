import org.junit.Test;

import java.sql.*;


public class JDBCTest {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/TestDB?useSSL=false&useEncoding=true&characterEncoding=UTF-8";
    static final String USER = "root";
    static final String PASS = "toor";

    @Test
    public void testConnections() throws SQLException {

        Connection conn = null;//= DBConnection.getConnection()


        try {
            //Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //Open a connection
            System.out.println("Connecting to database... JDBCRest");

            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Assert.assertNotNull(conn);

        Statement statement = null;
        statement = conn.createStatement();
        ResultSet resultSet = null;

        //Example

//        resultSet = statement.executeQuery("SELECT * FROM ORDERS;");
//        while (resultSet.next()) {
//            int qty = resultSet.getInt("QTY");
//            System.out.println("QTY =" + qty);
//
//        }
//        Assert.assertNotNull(resultSet);
//        resultSet.close();


        ////Вывести список служащих и офисов, в которых они работают (таблицы
        ////        SALESREPS И OFFICES).
//
//        resultSet = statement.executeQuery("SELECT NAME, OFFICE " +
//                "                            FROM salesreps,offices" +
//                "                           WHERE MGR = EMPL_NUM");
//        while (resultSet.next()) {
//            int office = resultSet.getInt("OFFICE");
//            String name = resultSet.getString("NAME");
//            System.out.println(name + ">>" + office);
//        }
//        Assert.assertNotNull(resultSet);
//        resultSet.close();

        ////        Вывести список заказов, сделанных на прошлой неделе, включая следую­
        //////        щую информацию: сrоимосrь заказа, имя клиента, сделавшего заказ, и на­
        //////        звание заказанного товара (таблицы ORDERS, CUSTOMERS и PRODUCTS).
//
//        resultSet = statement.executeQuery("SELECT AMOUNT, COMPANY, DESCRIPTION " +
//                "                            FROM orders,customers, products" +
//                "                           WHERE CUST = CUST_NUM and MFR = MFR_ID and ORDER_DATE = 2016-07-10");
//        Assert.assertTrue(resultSet.next());
////        if (resultSet.next()) {
////            int amount = resultSet.getInt("AMOUNT");
////            String name = resultSet.getString("COMPANY");
////            String desc = resultSet.getString("DESCRIPTION");
////            System.out.println(name + ">>" + amount + ">>" + desc);
////        }
////
//        Assert.assertNotNull(resultSet);
//        resultSet.close();


        //        Показать все заказы, принятые в восточном регионе, в том числе описа­
        //        ния товаров и имена служащих, принявших заказы (таблицы ORDERS,
        //        SALESREPS, OFFICES И PRODUCTS).

//        resultSet = statement.executeQuery("SELECT  NAME, DESCRIPTION " +
//                "                            FROM SALESREPS,OFFICES, products, orders" +
//                "                           WHERE   MFR = MFR_ID and REGION = 'Eastern'");
//        Assert.assertTrue(resultSet.next());
//        while (resultSet.next()) {
//
//            String name = resultSet.getString("NAME");
//            String desc = resultSet.getString("DESCRIPTION");
//            System.out.println(name + ">>" + ">>" + desc);
//        }
//
//        Assert.assertNotNull(resultSet);
//        resultSet.close();

        //Вывести список всех служащих с городами и регионами, в которъzх они работают.

//        resultSet = statement.executeQuery("SELECT NAME , CITY, REGION" +
//                " FROM SALESREPS , OFFICES" +
//                " WHERE REP_OFFICE = OFFICE");
//        while (resultSet.next()) {
//
//            String name = resultSet.getString("NAME");
//            String city = resultSet.getString("CITY");
//            String region = resultSet.getString("REGION");
//            System.out.println(name + ">>" + region + ">>" + city);
//        }
//
//        Assert.assertNotNull(resultSet);
//        resultSet.close();


        //Въюести список офисов с именами и должностями их руководителей.

//        resultSet = statement.executeQuery("SELECT CITY, NAME , TITLE" +
//                "  FROM OFFICES , SALESREPS " +
//                " WHERE MGR = EMPL_NUM ");
//        while (resultSet.next()) {
//
//            String name = resultSet.getString("NAME");
//            String city = resultSet.getString("CITY");
//            String title = resultSet.getString("TITLE");
//            System.out.println(name + ">>" + title + ">>" + city);
//        }
//        Assert.assertNotNull(resultSet);
//        resultSet.close();



        //Вывести список всех служащих с городами и регионами, в которых они работают.


//        resultSet = statement.executeQuery("SELECT NAME , CITY , REGION" +
//                               " FROM SALESREPS JOIN OFFICES" +
//                               " ON REP_OFFICE = OFFICE ");
//
////                  "SELECT NAME , CITY, REGION" +
//////                " FROM SALESREPS , OFFICES" +
//////                " WHERE REP_OFFICE = OFFICE");
//
//        while (resultSet.next()) {
//
//            String name = resultSet.getString("NAME");
//            String city = resultSet.getString("CITY");
//            String title = resultSet.getString("REGION");
//            System.out.println(name + ">>" + title + ">>" + city);
//        }
//        Assert.assertNotNull(resultSet);
//        resultSet.close();



        //Вывести список офисов с именами и должностszми их руководителей.


//        resultSet = statement.executeQuery("SELECT CITY, NAME , TITLE" +
//                "  FROM OFFICES JOIN SALESREPS " +
//                " WHERE MGR = EMPL_NUM ");
//
//        while (resultSet.next()) {
//
//            String name = resultSet.getString("NAME");
//            String city = resultSet.getString("CITY");
//            String title = resultSet.getString("TITLE");
//            System.out.println(name + ">>" + title + ">>" + city);
//        }
//        Assert.assertNotNull(resultSet);
//        resultSet.close();


        //Перечислитъ офисы, план продаж которых превы�иает $600 ООО.


//        resultSet = statement.executeQuery("SELECT CITY, NAME , TITLE" +
//                " FROM OFFICES JOIN SALESREPS" +
//                " ON MGR = EMPL_NUM" +
//                " WHERE TARGET > 600000.00");
//
//        while (resultSet.next()) {
//
//            String name = resultSet.getString("NAME");
//            String city = resultSet.getString("CITY");
//            String title = resultSet.getString("TITLE");
//            System.out.println(name + ">>" + title + ">>" + city);
//        }
//        Assert.assertNotNull(resultSet);
//        resultSet.close();



//        Вывести список всех заказов, включая стоимости и описания товаров.

//
//        resultSet = statement.executeQuery("SELECT ORDER_NUM, AMOUNT , DESCRIPTION" +
//                " FROM ORDERS JOIN PRODUCTS" +
//                " ON MFR =MFR_ID " +
//                " AND PRODUCT = PRODUCT_ID;");
//
//        while (resultSet.next()) {
//
//            String name = resultSet.getString("DESCRIPTION");
//
//            System.out.println(name + ">>" );
//        }
//        Assert.assertNotNull(resultSet);
//        resultSet.close();
            //
//        resultSet = statement.executeQuery("SELECT ORDER_NUM , AMOUNT , DESCRIPTION" +
//                " FROM ORDERS NATURAL JOIN PRODUCTS");
//        Assert.assertNotNull(resultSet);
//        resultSet.close();
            //не выполнелись запросы

//        resultSet = statement.executeQuery("SELECT ORDER_NUM , AMOUNT , DESCRIPTION" +
//                                          " FROM orders JOIN products" +
//                                          " USING (MFR, PRODUCT)");
//        Assert.assertNotNull(resultSet);
//        resultSet.close();
            //

//        resultSet = statement.executeQuery("SELECT ORDER_NUM , AMOUNT , DESCRIPTION" +
//
//                " FROM ORDERS JOIN PRODUCTS" +
//                " ON ORDERS.MFR = PRODUCTS.MFR_ID" +
//                " AND ORDERS.PRODUCT = PRODUCTS.PRODUCT_ID");
//        Assert.assertNotNull(resultSet);
//        resultSet.close();

            //        Въюести список заказов стоимостью выше $25 ООО, включающий имя служащего,
            //
            //        принявшего заказ, и имя клиента, сделавшего его.


            //
//        resultSet = statement.executeQuery("SELECT ORDER_NUM , AMOUNT , COMPANY , NAME " +
//
//                "FROM ORDERS JOIN CUSTOMERS ON CUST =CUST_NUM" +
//                " JOIN SALESREPS ON REP = EMPL_NUM" +
//                " WHERE AMOUNT>25000.00" );
//        Assert.assertNotNull(resultSet);
//        resultSet.close();

                //Вывести список заказов стоимостью выше $25 ООО, включающий имsz клиента, сде­
//        лавшего заказ, имsz закрепленного за ним служащего и офис, в котором работает
//        этот служащий.


//        resultSet = statement.executeQuery("SELECT ORDER_NUM , AMOUNT , COMPANY , NAME , CITY" +
//
//               " FROM ORDERS , CUSTOMERS , SALESREPS , OFFICES" +
//
//               " WHERE CUST = customers.CUST_NUM" +
//
//               " AND CUST_REP = EMPL_NUM" +
//
//               " AND REP_OFFICE = OFFICE" +
//
//               " AND AMOUNT > 25000.00;" );
//        Assert.assertNotNull(resultSet);
//        resultSet.close();
    //

//        resultSet = statement.executeQuery("SELECT ORDER_NUM, AMOUNT , ORDER_DATE , NAME"+
//
//               " FROM ORDERS , SALESREPS"+
//
//               " WHERE ORDER_DATE = HIRE_DATE ");
//        Assert.assertNotNull(resultSet);
//        resultSet.close();



    //
//        resultSet = statement.executeQuery("SELECT salesreps.*, CITY, REGION" +
//                "        FROM SALESREPS , OFFICES" +
//                "        WHERE REP_OFFiCE = OFFICE ");
//        Assert.assertNotNull(resultSet);
//        resultSet.close();


        //
//        resultSet = statement.executeQuery("SELECT SALESREPS.NAME , SALESREPS . QUOTA , MGRS.QUOTA" +
//
//                " FROM SALESREPS , SALESREPS MGRS" +
//
//                " WHERE salesreps.MANAGER = MGRS.EMPL_NUM" +
//
//                " AND SALESREPS.QUOTA > MGRS . QUOTA ;");
//        Assert.assertNotNull(resultSet);
//        resultSet.close();

//        //SELECT SALESREPS . NAМE , QUOTA, SAМ . BI RTHDAYS . BI RTH_DATE
//
//        FROM SALESREPS , B IRTHDAYS
//
//        WHERE SALESREPS . NAМE = SAМ.BI RTHDAYS . NAМE ;
//
//        Если вместо имен двух таблиц использовать псевдонимы s и в, то и вводить, и чи­
//
//        тать этот запрос будет легче.
//
//                Вывести список имен, плановых обьемов продаж и дней рождения служащих.
//
//        S ELECT S.NAМE , S . QUOTA , B.BI RTH_DATE
//
//        FROM SALESREPS S, SAМ.BIRTHDAYS В
//
//        WHERE S.NAМE = В.NАМЕ ;

        //
//        Въzвести список служащих и городов, где они работают.
//
//        SELECT NАМЕ , CITY
//
//        FROM SALESREPS LEFT OUTER JOIN OFFI CES
//
//        ON REP_OFFICE = OFFICE ;
        //
//        Вывести список девочек 11 .мальчиков из одних и тех же городов, вклюtf11S/ тех, кто
//
//        не имеет пары.
//
//                SELECT *
//
//                FROM GIRLS FULL OUTER JOIN BOYS
//
//        ON GIRLS . CI TY = BOYS . CI TY;

            //
//        Вывести список девоЧЕк и мальчиков из одних и тех же городов и девоЧЕк, не
//
//        имеющих пары.
//
//        SELECT *
//
//                FROM GIRLS LEFT OUТER JOIN BOYS
//
//        ON GIRLS . CI TY = BOYS . CI TY;

                //
//        Вывести список девоЧЕк и мальчиков из одних и тех же городов и мальчиков,
//
//                не имеющих пары.

                //








        statement.close();
        conn.close();
    }
}
