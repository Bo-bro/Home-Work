package org.demo.dao;

import org.demo.models.Customer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class CustomerDao {


    private final Connection connection;

    public CustomerDao(Connection connection) {
        this.connection = connection;
    }


    public boolean save(Customer customer) {
        String sql = String.format("insert into CUSTOMERS(CUST_NUM,COMPANY,CREDIT_LIMIT) values(%d,'%s','%s')",
                customer.getId(), customer.getCompany(), customer.getCredit_limit());
        return executeSql(sql);
    }

    public boolean update(Customer customer) {
        String sql = String.format("update CUSTOMERS set COMPANY='%s', CREDIT_LIMIT='%s' where CUST_NUM=%d",
                customer.getCompany(), customer.getCredit_limit(), customer.getId());
        return executeSql(sql);
    }

    public boolean delete(Customer customer) {
        String sql = String.format("delete from CUSTOMERS where CUST_NUM=%s",
                customer.getId());
        return executeSql(sql);
    }

    public Customer getById(int id) {
        String sql = String.format("select CUST_NUM,COMPANY,CREDIT_LIMIT from CUSTOMERS where CUST_NUM=%d",
                id);
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            Customer customer = null;
            if (resultSet.next()) {
                customer = new Customer();
                customer.setId(resultSet.getInt("CUST_NUM"));
                customer.setCompany(resultSet.getString("COMPANY"));
                customer.setCredit_limit(resultSet.getBigDecimal("CREDIT_LIMIT"));
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

    public List<Customer> getAll() {
        String sql = "select CUST_NUM,COMPANY,CREDIT_LIMIT from CUSTOMERS";
        Statement statement = null;
        List<Customer> customers = new ArrayList<Customer>();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setId(resultSet.getInt("CUST_NUM"));
                customer.setCompany(resultSet.getString("COMPANY"));
                customer.setCredit_limit(resultSet.getBigDecimal("CREDIT_LIMIT"));
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


