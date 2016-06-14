package org.demo.dao.impl;

import org.ProductsEntity;
import org.demo.dao.api.ProductDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao{
    private final Connection connection;

    public ProductDaoImpl(Connection connection) {
        this.connection = connection;
    }


    public boolean save(ProductsEntity product) {
        String sql = String.format("insert into PRODUCTS(QTY_ON_HAND,PRICE,DESRIPTION) values(%d,'%s','%s')",
                product.getQtyOnHand(), product.getPrice(), product.getDescription());
        return executeSql(sql);
    }

    public boolean update(ProductsEntity product) {
        String sql = String.format("update PRODUCTS set PRICE='%s', DESRIPTION='%s' where QTY_ON_HAND=%d",
                product.getPrice(), product.getDescription(), product.getQtyOnHand());
        return executeSql(sql);
    }

    public boolean delete(ProductsEntity product) {
        String sql = String.format("delete from PRODUCTS where QTY_ON_HAND=%s",
                product.getQtyOnHand());
        return executeSql(sql);
    }

    public ProductsEntity getById(int id) {
        String sql = String.format("select QTY_ON_HAND,PRICE,DESRIPTION from PRODUCTS where QTY_ON_HAND=%d",
                id);
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            ProductsEntity product = null;
            if (resultSet.next()) {
                product = new ProductsEntity();
                product.setQtyOnHand(resultSet.getInt("QTY_ON_HAND"));
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

    public List<ProductsEntity> getAll() {
        String sql = "select QTY_ON_HAND,PRICE,DESRIPTION from PRODUCTS";
        Statement statement = null;
        List<ProductsEntity> products = new ArrayList<ProductsEntity>();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                ProductsEntity product = new ProductsEntity();
                product.setQtyOnHand(resultSet.getInt("QTY_ON_HAND"));
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

