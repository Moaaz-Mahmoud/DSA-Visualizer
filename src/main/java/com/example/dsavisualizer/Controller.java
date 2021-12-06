package com.example.dsavisualizer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;


public class Controller {
    private Stage stage;
    private Scene scene;
    private Parent root;

    /* Scene Setters
     */
    public void switchPage(ActionEvent event, String sceneFile) throws IOException {
        root = FXMLLoader.load(getClass().getResource(sceneFile));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void switchToHomePage(ActionEvent event) throws IOException {
        switchPage(event, "home-page.fxml");
    }
    @FXML
    public void switchToLinkedListPage(ActionEvent event) throws IOException {
        switchPage(event, "linked-list-page.fxml");
    }
    @FXML
    public void switchToStackPage(ActionEvent event) throws IOException {
        switchPage(event, "stack-page.fxml");
    }
    public void switchToQueuePage(ActionEvent event) throws IOException{
        switchPage(event, "queue-page.fxml");
    }
    public void switchToBSTPage(ActionEvent event) throws IOException{
        switchPage(event, "bst-page.fxml");
    }
    public void switchToHeapPage(ActionEvent event) throws IOException{
        switchPage(event, "heap-page.fxml");
    }
    public void switchToHashTablePage(ActionEvent event) throws IOException{
        switchPage(event, "hash-table-page.fxml");
    }

    /* General
     */
    @FXML
    private Label welcomeText;
    @FXML
    protected void onHelloButtonClick() {}

}