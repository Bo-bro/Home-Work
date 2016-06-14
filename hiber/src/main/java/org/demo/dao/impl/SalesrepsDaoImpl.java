package org.demo.dao.impl;

import org.SalesrepsEntity;
import org.demo.dao.api.SalesrepsDao;
//import org.demo.models.Salesreps;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SalesrepsDaoImpl extends CrudDaoImpl<SalesrepsEntity,Integer> implements SalesrepsDao<SalesrepsEntity,Integer>{
    private final Connection connection;

    public SalesrepsDaoImpl(Connection connection) {
        this.connection = connection;
    }


    public boolean save(SalesrepsEntity salesreps) {
        String sql = String.format("insert into SALEAREPS(EMPL_NUM,NAME,AGE,TITLE,HIRE_DATE) values(%d,'%s',%d,'%s','%s')",
                salesreps.getEmplNum(), salesreps.getName(), salesreps.getAge(), salesreps.getTitle(), salesreps.getHireDate());
        return executeSql(sql);
    }

    public boolean update(SalesrepsEntity salesreps) {
        String sql = String.format("update SALEAREPS set HIRE_DATE='%s',TITLE='%s',NAME='%s', AGE='%d' where EMPL_NUM=%d",
                salesreps.getHireDate(), salesreps.getTitle(), salesreps.getName(), salesreps.getAge(), salesreps.getEmplNum());
        return executeSql(sql);
    }

    public boolean delete(SalesrepsEntity salesreps) {
        String sql = String.format("delete from SALEAREPS where EMPL_NUM=%s",
                salesreps.getEmplNum());
        return executeSql(sql);
    }

    public SalesrepsEntity getById(int id) {
        String sql = String.format("select EMPL_NUM,NAME,AGE,TITLE,HIRE_DATE from SALEAREPS where EMPL_NUM=%d",
                id);
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            SalesrepsEntity salesreps = null;
            if (resultSet.next()) {
                salesreps = new SalesrepsEntity();
                salesreps.setEmplNum(resultSet.getInt("EMPL_NUM"));
                salesreps.setName(resultSet.getString("NAME"));
                salesreps.setAge(resultSet.getInt("AGE"));
                salesreps.setTitle(resultSet.getString("TITLE"));
                salesreps.setHireDate(resultSet.getDate("HIRE_DATE"));
            }
            resultSet.close();
            return salesreps;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public List<SalesrepsEntity> getAll() {
        String sql = "select EMPL_NUM,NAME,AGE from SALEAREPS";
        Statement statement = null;
        List<SalesrepsEntity> salesrepss = new ArrayList<SalesrepsEntity>();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                SalesrepsEntity salesreps = new SalesrepsEntity();
                salesreps.setEmplNum(resultSet.getInt("EMPL_NUM"));
                salesreps.setName(resultSet.getString("NAME"));
                salesreps.setAge(resultSet.getInt("AGE"));
                salesreps.setTitle(resultSet.getString("TITLE"));
                salesreps.setHireDate(resultSet.getDate("HIRE_DATE"));

                salesrepss.add(salesreps);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return salesrepss;
    }

    private boolean executeSql(String sql) {
        int count = 0;
        Statement statement = null;
        try {
            statement = connection.createStatement();
            count = statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return count == 1;
    }
}