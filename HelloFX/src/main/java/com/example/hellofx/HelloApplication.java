package com.example.hellofx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;


import java.awt.*;
import java.io.File;
import java.io.IOException;

public class HelloApplication extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Scene scene = new Scene(root);

        File iconFile = new File("src/main/resources/icon.png");
        Image icon = new Image(iconFile.toURI().toURL().toString());

        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.setTitle("Stage demo");

        stage.show();
    }
}