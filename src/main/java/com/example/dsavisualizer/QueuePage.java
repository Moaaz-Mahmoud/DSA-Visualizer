package com.example.dsavisualizer;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Ellipse;

import java.util.LinkedList;
import java.util.Queue;


public class QueuePage extends Controller{
    //Constants
    private static final int MAX_SIZE = 5;
    //Layout components
    @FXML TextField textField;
    @FXML Button addButton;
    @FXML Button removeButton;
    @FXML Label label0; @FXML Label label1; @FXML Label label2;
    @FXML Label label3; @FXML Label label4;
    @FXML Ellipse ellipse0; @FXML Ellipse ellipse1; @FXML Ellipse ellipse2;
    @FXML Ellipse ellipse3; @FXML Ellipse ellipse4;
    //Structures
    private Queue<String> queue = new LinkedList<>();
    private Label[] labels = {label0, label1, label2, label3, label4};
    Ellipse[] ellipses = {ellipse0, ellipse1, ellipse2, ellipse3, ellipse4};

    //Controller methods
    public void onAddButtonClick(){
        if(queue.size() == MAX_SIZE) return;
        String stringToPush = textField.getText();
        if(stringToPush.length() >= 7)
            stringToPush = stringToPush.substring(0, 6) + "...";
        labels[queue.size()].setText(stringToPush);
        ellipses[queue.size()].setVisible(true);
        queue.add(stringToPush);
    }
    public void onRemoveButtonClick(){
        if(queue.size() == 0) return;
        if(queue.size() == 1) {
            labels[0].setText("");
            ellipses[0].setVisible(false);
        }
        else {
            for (int i = 0; i < queue.size()-1; i++)
                labels[i].setText(labels[i + 1].getText());
            labels[queue.size()-1].setText("");
            ellipses[queue.size()-1].setVisible(false);
        }
        queue.remove();
    }
    //Other essential methods
    public void initialize(){
        labels = new Label[MAX_SIZE];
        labels[0] = label0; labels[1] = label1;
        labels[2] = label2; labels[3] = label3;
        labels[4] = label4;
        ellipses = new Ellipse[MAX_SIZE];
        ellipses[0] = ellipse0; ellipses[1] = ellipse1;
        ellipses[2] = ellipse2; ellipses[3] = ellipse3;
        ellipses[4] = ellipse4;
        for(var ellipse : ellipses) ellipse.setVisible(false);
    }
}
