package com.lines.connected.playerfx;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class EntryPointOfApplicationNew extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        ListView<String> carListView = new ListView<>();
        ObservableList<String> carItems = carListView.getItems();
        carItems.addAll("Audi","BMW","Mercedes","VW","Skoda","Fiat","Fiat Panda","Volvo","Opel","Peugeot");
        MultipleSelectionModel<String> selectionModel=  carListView.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.MULTIPLE);


        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(carListView);
        Scene scene = new Scene(borderPane,500,300);
        stage.setTitle("Favourite car");
        stage.setScene(scene);
        stage.show();



    }

    public static void main(String[] args) {
        launch();
    }
}
