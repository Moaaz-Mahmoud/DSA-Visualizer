package com.example.dsavisualizer;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
    private List<String> list = new LinkedList<>();
    //Controller methods
    public void onAddButtonClick(){
        int position = Integer.parseInt(positionField.getText());
        String value = valueField.getText();
        if(value.length() > 5) value = value.substring(0, 4) + "...";
        if(list.size() == MAX_SIZE || position > list.size()) return;
        list.add(position, value);
        render();
    }
    public void onRemoveButtonClick(){
        int position = Integer.parseInt(positionField.getText());
        if(position >= list.size()) return;
        list.remove(position);
        render();
    }
    //Other essential methods
    public void render(){
        int i = 0;
        for(var elem : list) {
            labels[i].setText(elem);
            rectangles[i++].setVisible(true);
        }
        for(; i < MAX_SIZE; i++){
            labels[i].setText("");
            rectangles[i].setVisible(false);
        }
    }
    public void initialize(){
        labels = new Label[MAX_SIZE];
        labels[0] = label0; labels[1] = label1; labels[2] = label2;
        labels[3] = label3; labels[4] = label4; labels[5] = label5;
        rectangles = new Rectangle[MAX_SIZE];
        rectangles[0] = rectangle0; rectangles[1] = rectangle1;
        rectangles[2] = rectangle2; rectangles[3] = rectangle3;
        rectangles[4] = rectangle4; rectangles[5] = rectangle5;
        for(var rectangle : rectangles)
            rectangle.setVisible(false);
    }
}
