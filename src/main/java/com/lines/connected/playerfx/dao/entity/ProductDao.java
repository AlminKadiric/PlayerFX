package com.lines.connected.playerfx.dao.entity;

import com.lines.connected.playerfx.dao.connection.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements Dao<Product> {
    @Override
    public Product save(Product entity) {
        return null;
    }

    @Override
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        String sqlProduct = "SELECT * FROM products";
        Connection connection = ConnectionPool.getINSTANCE().getConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(sqlProduct)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Product product = new Product();
                product.setId(resultSet.getLong("id"));
                 product.setName(resultSet.getString("name"));
                 product.setDescription(resultSet.getString("description"));
                 product.setQuantity(resultSet.getInt("quantity"));
                 product.setPrice(resultSet.getBigDecimal("preis"));
                 products.add(product);

            }


        }catch (SQLException exception){
            System.err.println(exception.getMessage());
        }
        ConnectionPool.getINSTANCE().releaseConnection(connection);
        return products;
    }

    @Override
    public Product get(Long id) {
        return null;
    }

    @Override
    public Product update(Product entity) {
        return null;
    }

    @Override
    public boolean delete(Product entity) {
        return false;
    }
}
