package com.example.hellofx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.skin.TableColumnHeader;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HelloController {
    java.sql.Connection connection = Connection.establishConnection("jdbc:mysql://localhost:3306/test");
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    TableView table;
    @FXML
    TableColumn idCol;
    @FXML
    TableColumn emailCol;
    @FXML
    TableColumn firstNameCol;
    @FXML
    TableColumn lastNameCol;
    @FXML
    TextField emailField;
    @FXML
    TextField firstNameField;
    @FXML
    TextField lastNameField;
    public void populateTable(ActionEvent e){
        if(!table.getItems().isEmpty()){
            table.getItems().clear();
        }
        String sql = "SELECT * FROM guests";
        try{
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        while(rs.next()){
            Guest guest = new Guest(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4));
            table.getItems().add(guest);
        }
        } catch (Exception exception){
        }
    }
    public void addRow(ActionEvent e){
        switchToGuestTable(e);
    }
    public void switchToAddForm(ActionEvent e){
        try {
            root = FXMLLoader.load(getClass().getResource("addForm.fxml"));
            stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch(Exception exception){
        }
    }
    public void switchToGuestTable(ActionEvent e){
        try {
            root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
            stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch(Exception exception){
        }
    }
}