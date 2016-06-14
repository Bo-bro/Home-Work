import org.OfficesEntity;
import org.demo.dao.api.OfficeDao;
import org.demo.dao.impl.OfficeDaoImpl;
import org.demo.helpers.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;

//import org.demo.dao.impl.OfficeDao;

public class CriteriaTest {
    @Test
    public void testConnection() {
       final Connection connection;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            OfficeDao officeDao = OfficeDaoImpl.getInstance();
            List<OfficesEntity> officeDaoList =officeDao.getAll();
            Assert.assertNotNull(officeDaoList);
            System.out.println(  officeDaoList.toString());
            for (OfficesEntity officesEntity : officeDaoList) {
                System.out.println(officesEntity.toString());

            }
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

