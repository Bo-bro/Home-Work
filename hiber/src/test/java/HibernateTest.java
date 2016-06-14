import org.SalesrepsEntity;
import org.demo.helpers.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

public class HibernateTest {
    @Test
    public void testConnection() {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            SalesrepsEntity office = session.get(SalesrepsEntity.class, 101);
            Assert.assertNotNull(office);
  System.out.println(  office.toString()+ "office.toString()");
//            Assert.assertNotNull(office.getRegion());
//            System.out.println(  office.getRegion()+ "office.toString().region");
          //  Manager manager = office.getManager();
         //   Assert.assertNotNull(manager);
          //  System.out.println(  manager.toString()+ "manager");

            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
