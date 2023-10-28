package com.lines.connected.playerfx;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.ReadOnlyProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class EntryPointOfApplication extends Application {


 /*   private CheckBox pizzaCheckBox;
    private CheckBox cevapiCheckBox;
    private CheckBox pittaCheckBox;*/

    private ChoiceBox<String> fruitChoiceBox;
    private Label messageLabel;


    @Override
    public void start(Stage stage) throws IOException {
      /*  FXMLLoader fxmlLoader = new FXMLLoader(EntryPointOfApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();*/
/*
        pizzaCheckBox = new CheckBox("Pizza");
        cevapiCheckBox = new CheckBox("Cevapi");
        pittaCheckBox = new CheckBox("Pita");
        pittaCheckBox.setSelected(true);
        */
        fruitChoiceBox = new ChoiceBox<>();
        fruitChoiceBox.setValue("Banana");
        SingleSelectionModel<String> fruitSelectionModel = fruitChoiceBox.getSelectionModel();
        ReadOnlyProperty <String>  fruitStringReadOnlyProperty = fruitSelectionModel.selectedItemProperty();
        fruitStringReadOnlyProperty.addListener((observable,oldSelectedValue,newSelectedValue) -> {
            System.out.println(observable.getClass().getName());
            System.out.println("OLD: " + oldSelectedValue);
            System.out.println("NEW: " + newSelectedValue);

        });
        ObservableList<String> fruits = fruitChoiceBox.getItems();
        fruits.add("Banana");
        fruits.add("apple");
        fruits.add("Watermelon");
        fruits.add("Blackberry");
        fruits.add("Raspberry");
        fruits.add("Pineapple");
        fruits.add("Kiwi");
        fruits.add("Orange");
        fruits.add("Lemon");


        Button orderFoodButton = new Button("Naruci");
        messageLabel = new Label();
        orderFoodButton.setOnAction(this::onOrderButtonClick);


        VBox foodVBox = new VBox(10);
        foodVBox.setPadding(new Insets(20, 20, 20, 20));
        ObservableList<Node> nodes = foodVBox.getChildren();
        nodes.add(fruitChoiceBox);


        nodes.add(orderFoodButton);

        Scene scene = new Scene(foodVBox, 300, 200);
        stage.setScene(scene);
        stage.show();


    }

    private void onOrderButtonClick(ActionEvent event) {
        String odabranoVoce = fruitChoiceBox.getValue();
        messageLabel.setText("Odabrano voce: " + odabranoVoce);


    }


    public static void main(String[] args) {
        launch();
    }
/*
    private class OrderButtonEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            System.out.println("Order Button neko klikno......");
            if (pittaCheckBox.isSelected()) {
                System.out.println("Neko voli pitu");
            }
            if (pizzaCheckBox.isSelected()) {
                System.out.println("Neko voli pizzu!");
            }
            if (cevapiCheckBox.isSelected()) {
                System.out.println("Neko voli cevape");
            }
        }
    }*/

}