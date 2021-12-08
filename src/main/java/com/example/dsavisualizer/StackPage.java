package com.example.dsavisualizer;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.Stack;

public class StackPage extends Controller{
    //Constants
    private final int MAX_SIZE = 5;

    //Structures
    private Stack<String> stk = new Stack<>();
        //Labels
        @FXML Label label0; @FXML Label label1; @FXML Label label2;
        @FXML Label label3; @FXML Label label4;
    private Label[] labels = { label0, label1, label2, label3, label4 };

    //Components (other than labels)
    @FXML TextField textField;
    @FXML Button pushButton;
    @FXML Button popButton;

    //Controller methods
    public void onPushButtonClick(){
        if(stk.size() == MAX_SIZE) return;
        String stringToPush = textField.getText();
        labels[stk.size()].setText(stringToPush);
        stk.push(stringToPush);
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
