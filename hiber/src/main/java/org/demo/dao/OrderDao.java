package org.demo.dao;


import org.demo.models.Order;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class OrderDao {

    private final Connection connection;

    public OrderDao(Connection connection) {
        this.connection = connection;
    }


    public boolean save(Order order) {
        String sql = String.format("insert into ORDERS(ORDER_NUM,ORDER_DATE,QTY) values(%d,'%s','%s')",
                order.getId(), order.getOrder_date(), order.getQty());
        return executeSql(sql);
    }

    public boolean update(Order order) {
        String sql = String.format("update ORDERS set ORDER_DATE='%s', QTY='%s' where ORDER_NUM=%d",
                order.getOrder_date(), order.getQty(), order.getId());
        return executeSql(sql);
    }

    public boolean delete(Order order) {
        String sql = String.format("delete from ORDERS where ORDER_NUM=%s",
                order.getId());
        return executeSql(sql);
    }

    public Order getById(int id) {
        String sql = String.format("select ORDER_DATE,QTY,CUST,MFR,REP from ORDERS where ORDER_NUM=%d",
                id);
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            Order order = null;
            if (resultSet.next()) {
                order = new Order();
                order.setId(resultSet.getInt("ORDER_NUM"));
                order.setOrder_date(resultSet.getDate("ORDER_DATE"));
                order.setQty(resultSet.getInt("QTY"));
            }
            resultSet.close();
            return order;
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

    public List<Order> getAll() {
        String sql = "select ORDER_NUM,ORDER_DATE,QTY from ORDERS";
        Statement statement = null;
        List<Order> orders = new ArrayList<Order>();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Order order = new Order();
                order.setId(resultSet.getInt("ORDER_NUM"));
                order.setOrder_date(resultSet.getDate("ORDER_DATE"));
                order.setQty(resultSet.getInt("QTY"));
                orders.add(order);
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
        return orders;
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


