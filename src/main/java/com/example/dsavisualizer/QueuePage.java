package com.example.dsavisualizer;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.LinkedList;
import java.util.Queue;

public class QueuePage extends Controller{
    //Constants
    private static final int MAX_SIZE = 5;
    //Layout components
    @FXML TextField textField;
    @FXML Button addButton;
    @FXML Button removeButton;
        //Labels
        @FXML Label label0; @FXML Label label1; @FXML Label label2;
        @FXML Label label3; @FXML Label label4;
    //Structures
    private Queue<String> queue = new LinkedList<>();
    private Label[] labels = {label0, label1, label2, label3, label4};

    //Controller methods
    public void onAddButtonClick(){
        if(queue.size() == MAX_SIZE) return;
        String stringToPush = textField.getText();
        labels[queue.size()].setText(stringToPush);
        queue.add(stringToPush);
    }
    public void onRemoveButtonClick(){
        if(queue.size() == 0) return;
        if(queue.size() == 1) {
            labels[0].setText("");
        }
        else {
            for (int i = 0; i < queue.size()-1; i++)
                labels[i].setText(labels[i + 1].getText());
            labels[queue.size()-1].setText("");
        }
        queue.remove();
    }
    //Other essential methods
    public void initialize(){
        labels = new Label[MAX_SIZE];
        labels[0] = label0;
        labels[1] = label1;
        labels[2] = label2;
        labels[3] = label3;
        labels[4] = label4;
    }
}
