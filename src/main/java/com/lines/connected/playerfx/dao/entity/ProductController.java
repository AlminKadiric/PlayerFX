package com.lines.connected.playerfx.dao.entity;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class ProductController {
    private ProductDao productDao = new ProductDao();

    public ObservableList<Product> loadProducts(){
        List<Product> productList = productDao.getAll();
        ObservableList<Product> productObservableList = FXCollections.observableList(productList);
       return productObservableList;
    }

    public ProductDao getProductDao() {
        return productDao;
    }
}
