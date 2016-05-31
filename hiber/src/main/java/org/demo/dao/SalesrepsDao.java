package org.demo.dao;

import org.demo.models.Salesreps;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SalesrepsDao {
    private final Connection connection;

    public SalesrepsDao(Connection connection) {
        this.connection = connection;
    }


    public boolean save(Salesreps salesreps) {
        String sql = String.format("insert into SALEAREPS(EMPL_NUM,NAME,AGE,TITLE,HIRE_DATE) values(%d,'%s',%d,'%s','%s')",
                salesreps.getEmpl_num(), salesreps.getName(), salesreps.getAge(), salesreps.getTitle(), salesreps.getHire_date());
        return executeSql(sql);
    }

    public boolean update(Salesreps salesreps) {
        String sql = String.format("update SALEAREPS set HIRE_DATE='%s',TITLE='%s',NAME='%s', AGE='%d' where EMPL_NUM=%d",
                salesreps.getHire_date(), salesreps.getTitle(), salesreps.getName(), salesreps.getAge(), salesreps.getEmpl_num());
        return executeSql(sql);
    }

    public boolean delete(Salesreps salesreps) {
        String sql = String.format("delete from SALEAREPS where EMPL_NUM=%s",
                salesreps.getEmpl_num());
        return executeSql(sql);
    }

    public Salesreps getById(int id) {
        String sql = String.format("select EMPL_NUM,NAME,AGE,TITLE,HIRE_DATE from SALEAREPS where EMPL_NUM=%d",
                id);
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            Salesreps salesreps = null;
            if (resultSet.next()) {
                salesreps = new Salesreps();
                salesreps.setEmpl_num(resultSet.getInt("EMPL_NUM"));
                salesreps.setName(resultSet.getString("NAME"));
                salesreps.setAge(resultSet.getInt("AGE"));
                salesreps.setTitle(resultSet.getString("TITLE"));
                salesreps.setHire_date(resultSet.getDate("HIRE_DATE"));
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

    public List<Salesreps> getAll() {
        String sql = "select EMPL_NUM,NAME,AGE from SALEAREPS";
        Statement statement = null;
        List<Salesreps> salesrepss = new ArrayList<Salesreps>();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Salesreps salesreps = new Salesreps();
                salesreps.setEmpl_num(resultSet.getInt("EMPL_NUM"));
                salesreps.setName(resultSet.getString("NAME"));
                salesreps.setAge(resultSet.getInt("AGE"));
                salesreps.setTitle(resultSet.getString("TITLE"));
                salesreps.setHire_date(resultSet.getDate("HIRE_DATE"));

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