package com.lines.connected.playerfx;

import com.lines.connected.playerfx.dao.entity.Product;
import com.lines.connected.playerfx.dao.entity.ProductController;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.AccessibleAction;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.math.BigDecimal;

public class EntryPoint extends Application {

    private TableView<Product> productTableView = new TableView<>();

    private ProductController productController = new ProductController();
    private TextField priceInput = new TextField();
    private TextField quantityInput = new TextField();
    private TextField nameInput = new TextField();

    @Override
    public void start(Stage stage) throws Exception {
        ObservableList<Product> productObservableList = productController.loadProducts();
        productTableView.setItems(productObservableList);

        TableColumn<Product,String> column = new TableColumn<>("Ime");
        column.setMinWidth(200);
        column.setCellValueFactory(new PropertyValueFactory<Product,String>("name"));
        TableColumn<Product,String> descriptionColumn = new TableColumn<>("Opis");
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        //TableColumn<Product, BigDecimal> priceColumn = new TableColumn<>("Cijena jedinicna");
      //  priceColumn.setCellValueFactory(new PropertyValueFactory<>("preis"));
        TableColumn<Product,BigDecimal> quantityColumn = new TableColumn<>("Kolicina");
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        productTableView.getColumns().addAll(column,descriptionColumn,/*priceColumn,*/quantityColumn);
        Button deleteButton = new Button("DELETE");
        deleteButton.setOnAction(this::onDeleteClickHandle);
        Button addButon = new Button("ADD");
        HBox formBox = new HBox();
        formBox.setPadding(new Insets(10));
        nameInput.setPromptText("Name...");
        priceInput.setPromptText("Price...");
        quantityInput.setPromptText("Quantity....");




        formBox.getChildren().addAll(nameInput,priceInput,quantityInput,deleteButton,addButon);




        VBox container = new VBox();
        ObservableList<Node> nodes = container.getChildren();
        nodes.add(productTableView);
        nodes.add(formBox);

        Scene scene = new Scene(container);
        stage.setScene(scene);
        stage.show();



    }
    private void onAddButtonClick(ActionEvent actionEvent){
        Product product = new Product();
        product.setName(nameInput.getText());
        product.setQuantity(Integer.parseInt(quantityInput.getText()));
        product.setPrice(new BigDecimal(priceInput.getText()));
        ObservableList<Product>allTableProducts = productTableView.getItems();
        allTableProducts.add(product);

    }

    private void  onDeleteClickHandle(ActionEvent actionEvent){
        ObservableList<Product> selectedProducts = productTableView.getSelectionModel().getSelectedItems();
        ObservableList<Product>allTableProducts = productTableView.getItems();
       selectedProducts.forEach(allTableProducts::remove);
    }

    public static void main(String[] args) {
        launch();
    }
}
