package org.demo.dao.impl;

import org.CustomersEntity;
import org.demo.dao.api.CustomerDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//import org.demo.models.CustomersEn;


public class CustomerDaoImpl implements CustomerDao {


    private final Connection connection;

    public CustomerDaoImpl(Connection connection) {
        this.connection = connection;
    }


    public boolean save(CustomersEntity customer) {
        String sql = String.format("insert into CUSTOMERS(CUST_NUM,COMPANY,CREDIT_LIMIT) values(%d,'%s','%s')",
                customer.getCustNum(), customer.getCompany(), customer.getCreditLimit());
        return executeSql(sql);
    }

    public boolean update(CustomersEntity customer) {
        String sql = String.format("update CUSTOMERS set COMPANY='%s', CREDIT_LIMIT='%s' where CUST_NUM=%d",
                customer.getCompany(), customer.getCreditLimit(), customer.getCustNum());
        return executeSql(sql);
    }

    public boolean delete(CustomersEntity customer) {
        String sql = String.format("delete from CUSTOMERS where CUST_NUM=%s",
                customer.getCustNum());
        return executeSql(sql);
    }

    public CustomersEntity getById(int id) {
        String sql = String.format("select CUST_NUM,COMPANY,CREDIT_LIMIT from CUSTOMERS where CUST_NUM=%d",
                id);
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            CustomersEntity customer = null;
            if (resultSet.next()) {
                customer = new CustomersEntity();
                customer.setCustNum(resultSet.getInt("CUST_NUM"));
                customer.setCompany(resultSet.getString("COMPANY"));
                customer.setCreditLimit(resultSet.getBigDecimal("CREDIT_LIMIT"));
            }
            resultSet.close();
            return customer;
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

    public List<CustomersEntity> getAll() {
        String sql = "select CUST_NUM,COMPANY,CREDIT_LIMIT from CUSTOMERS";
        Statement statement = null;
        List<CustomersEntity> customers = new ArrayList<CustomersEntity>();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                CustomersEntity customer = new CustomersEntity();
                customer.setCustNum(resultSet.getInt("CUST_NUM"));
                customer.setCompany(resultSet.getString("COMPANY"));
                customer.setCreditLimit(resultSet.getBigDecimal("CREDIT_LIMIT"));
                customers.add(customer);
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
        return customers;
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


