package org.demo.dao;

import org.demo.models.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    private final Connection connection;

    public ProductDao(Connection connection) {
        this.connection = connection;
    }


    public boolean save(Product product) {
        String sql = String.format("insert into PRODUCTS(QTY_ON_HAND,PRICE,DESRIPTION) values(%d,'%s','%s')",
                product.getQty_on_hand(), product.getPrice(), product.getDescription());
        return executeSql(sql);
    }

    public boolean update(Product product) {
        String sql = String.format("update PRODUCTS set PRICE='%s', DESRIPTION='%s' where QTY_ON_HAND=%d",
                product.getPrice(), product.getDescription(), product.getQty_on_hand());
        return executeSql(sql);
    }

    public boolean delete(Product product) {
        String sql = String.format("delete from PRODUCTS where QTY_ON_HAND=%s",
                product.getQty_on_hand());
        return executeSql(sql);
    }

    public Product getById(int id) {
        String sql = String.format("select QTY_ON_HAND,PRICE,DESRIPTION from PRODUCTS where QTY_ON_HAND=%d",
                id);
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            Product product = null;
            if (resultSet.next()) {
                product = new Product();
                product.setQty_on_hand(resultSet.getInt("QTY_ON_HAND"));
                product.setPrice(resultSet.getBigDecimal("PRICE"));
                product.setDescription(resultSet.getString("DESRIPTION"));
            }
            resultSet.close();
            return product;
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

    public List<Product> getAll() {
        String sql = "select QTY_ON_HAND,PRICE,DESRIPTION from PRODUCTS";
        Statement statement = null;
        List<Product> products = new ArrayList<Product>();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Product product = new Product();
                product.setQty_on_hand(resultSet.getInt("QTY_ON_HAND"));
                product.setPrice(resultSet.getBigDecimal("PRICE"));
                product.setDescription(resultSet.getString("DESRIPTION"));
                products.add(product);
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
        return products;
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

