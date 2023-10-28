package com.lines.connected.playerfx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.TreeSet;

public class EntryPointOfApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        TreeItem<String>root = new TreeItem<>("Programming");
        root.setExpanded(true);

        TreeItem<String> javaBranch = createBranch("Java",root);
        createBranch("Ruby",javaBranch);
        createBranch("Scala",javaBranch);
        createBranch("Spring",javaBranch);
        createBranch("Kotlin",javaBranch);
        createBranch("Dart",javaBranch);

        TreeItem<String> jsBranch = createBranch("JS",root);
        createBranch("Vue.js",jsBranch);
        createBranch("React.js",jsBranch);
        createBranch("Angular.js",jsBranch);

        TreeItem<String> pythonBranch = createBranch("Python",root);
        createBranch("Django",pythonBranch);
        createBranch("Flusk",pythonBranch);
        createBranch("Hug",pythonBranch);

        TreeView<String> languageTreeView=new TreeView<>(root);
        languageTreeView.setShowRoot(true);
        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(languageTreeView);

        Scene scene = new Scene(stackPane,500,300);
        stage.setScene(scene);
        stage.show();




    }

    private TreeItem<String> createBranch(String title,TreeItem<String>parent){
        TreeItem<String>item = new TreeItem<>(title);
        item.setExpanded(true);
        parent.getChildren().add(item);
        return item;
    }

    public static void main(String[] args) {
        launch();
    }
}
