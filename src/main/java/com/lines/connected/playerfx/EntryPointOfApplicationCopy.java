package com.lines.connected.playerfx;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class EntryPointOfApplicationCopy extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        ComboBox<String> favouriteMovieComboBox = new ComboBox<>();
        ObservableList<String> items = favouriteMovieComboBox.getItems();
        items.addAll("Notebook", "Good Will Hunting", "Godfather", "Godfather 2", "Mafia", "StarWars");
        favouriteMovieComboBox.setPromptText("Odaberi omiljeni film...");
        favouriteMovieComboBox.setEditable(true);
        favouriteMovieComboBox.setOnAction(e->{
            System.out.println(favouriteMovieComboBox.getValue());
        });
        VBox comboVBox = new VBox(10);
        comboVBox.setPadding(new Insets(20));
        comboVBox.getChildren().add(favouriteMovieComboBox);

        Scene scene = new Scene(comboVBox, 400, 300);
        stage.setTitle("Favourite Movie");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}
