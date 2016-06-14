package org.demo.dao.impl;

import org.OfficesEntity;
import org.demo.dao.api.OfficeDao;
import org.demo.helpers.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class OfficeDaoImpl implements OfficeDao{
   private static OfficeDaoImpl instance;

    private OfficeDaoImpl() {
        // create();
    }


    public static synchronized OfficeDaoImpl getInstance() {
        if (instance == null) {
            instance = new OfficeDaoImpl();
        }
        return instance;
    }


    public boolean save(OfficesEntity office) {
//        String sql = String.format("insert into OFFICES(OFFICE,CITY,REGION) values(%s,'%s','%s')",
//                office.getOffice(), office.getCity(), office.getRegion());
//        return executeSql(sql);
//        SessionFactory factory = HibernateUtil.getSessionFactory();
//        Session session = factory.openSession();
//        Transaction tx = null;
//        try {
//            tx = session.beginTransaction();
//            session.createCriteria(OfficesEntity.class).list();
//
//            tx.commit();
//            return session;
//        } catch (Exception e) {
//            if (tx != null) tx.rollback();
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
        return false;
    }

    public boolean update(OfficesEntity office) {
        String sql = String.format("update OFFICES set CITY='%s', REGION='%s' where OFFICE=%d",
                office.getCity(), office.getRegion(), office.getOffice());
        return executeSql(sql);
    }

    public boolean delete(OfficesEntity office) {
        String sql = String.format("delete from OFFICES where OFFICE=%s",
                office.getOffice());
        return executeSql(sql);
    }

    public OfficesEntity getById(int id) {
//        String sql = String.format("select OFFICE,CITY,REGION from OFFICES where OFFICE=%d",
//                id);
//        Statement statement = null;
//        try {
//            statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery(sql);
//            OfficesEntity office = null;
//            if (resultSet.next()) {
//                office = new OfficesEntity();
//                office.setOffice(resultSet.getInt("OFFICE"));
//                office.setCity(resultSet.getString("CITY"));
//                office.setRegion(resultSet.getString("REGION"));
//            }
//            resultSet.close();
//            return office;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            if (statement != null) {
//                try {
//                    statement.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
        return null;
    }

    public List<OfficesEntity> getAll() {
//        String sql = "select OFFICE,CITY,REGION from OFFICES";
//        Statement statement = null;
//        List<OfficesEntity> offices = new ArrayList<OfficesEntity>();
//        try {
//            statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery(sql);
//            while (resultSet.next()) {
//                OfficesEntity office = new OfficesEntity();
//                office.setOffice(resultSet.getInt("OFFICE"));
//                office.setCity(resultSet.getString("CITY"));
//                office.setRegion(resultSet.getString("REGION"));
//                offices.add(office);
//            }
//            resultSet.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            if (statement != null) {
//                try {
//                    statement.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        return offices;

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        List<OfficesEntity> officesEntityList =  (List<OfficesEntity>)session.createCriteria(OfficesEntity.class).list();


return officesEntityList;
    }

    private boolean executeSql(String sql) {
//        int count = 0;
//        Statement statement = null;
//        try {
//            statement = connection.createStatement();
//            count = statement.executeUpdate(sql);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            if (statement != null) {
//                try {
//                    statement.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
        return false;//count == 1;
    }
}
