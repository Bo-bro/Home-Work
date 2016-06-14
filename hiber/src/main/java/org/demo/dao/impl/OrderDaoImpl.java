package org.demo.dao.impl;


import org.OrdersEntity;
import org.demo.dao.api.OrderDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class OrderDaoImpl implements OrderDao{

    private final Connection connection;

    public OrderDaoImpl(Connection connection) {
        this.connection = connection;
    }


    public boolean save(OrdersEntity order) {
        String sql = String.format("insert into ORDERS(ORDER_NUM,ORDER_DATE,QTY) values(%d,'%s','%s')",
                order.getOrderNum(), order.getOrderDate(), order.getQty());
        return executeSql(sql);
    }

    public boolean update(OrdersEntity order) {
        String sql = String.format("update ORDERS set ORDER_DATE='%s', QTY='%s' where ORDER_NUM=%d",
                order.getOrderDate(), order.getQty(), order.getOrderNum());
        return executeSql(sql);
    }

    public boolean delete(OrdersEntity order) {
        String sql = String.format("delete from ORDERS where ORDER_NUM=%s",
                order.getOrderNum());
        return executeSql(sql);
    }

    public OrdersEntity getById(int id) {
        String sql = String.format("select ORDER_DATE,QTY,CUST,MFR,REP from ORDERS where ORDER_NUM=%d",
                id);
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            OrdersEntity order = null;
            if (resultSet.next()) {
                order = new OrdersEntity();
                order.setOrderNum(resultSet.getInt("ORDER_NUM"));
                order.setOrderDate(resultSet.getDate("ORDER_DATE"));
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

    public List<OrdersEntity> getAll() {
        String sql = "select ORDER_NUM,ORDER_DATE,QTY from ORDERS";
        Statement statement = null;
        List<OrdersEntity> orders = new ArrayList<OrdersEntity>();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                OrdersEntity order = new OrdersEntity();
                order.setOrderNum(resultSet.getInt("ORDER_NUM"));
                order.setOrderDate(resultSet.getDate("ORDER_DATE"));
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


