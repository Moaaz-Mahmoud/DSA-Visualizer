package com.example.dsavisualizer;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Rectangle;

import java.util.LinkedList;

public class LinkedListPage extends Controller{
    //Constants
    private final int MAX_SIZE = 6;
    //Layout components
    @FXML TextField valueField;
    @FXML TextField positionField;
    @FXML Button addButton;
    @FXML Button removeButton;
    @FXML Label label0; @FXML Label label1; @FXML Label label2;
    @FXML Label label3; @FXML Label label4; @FXML Label label5;
    @FXML Rectangle rectangle0; @FXML Rectangle rectangle1;
    @FXML Rectangle rectangle2; @FXML Rectangle rectangle3;
    @FXML Rectangle rectangle4; @FXML Rectangle rectangle5;
    //Structures
    private Rectangle[] rectangles;
    private Label[] labels;
    private LinkedList<String> list = new LinkedList<>();
    //Controller methods
    public void onAddButtonClick(){

    }
    public void onRemoveButtonClick(){

    }
    //Other essential methods
    public void render(){

    }
    public void initialize(){

    }
}
