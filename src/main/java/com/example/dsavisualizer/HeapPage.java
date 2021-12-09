package com.example.dsavisualizer;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HeapPage extends Controller{
    //Constants
    private final int MAX_SIZE = 7;
    //Layout components
    @FXML TextField textField;
    @FXML Button addButton;
    @FXML Button removeButton;
        //Labels
        @FXML Label label0; @FXML Label label1; @FXML Label label2;
        @FXML Label label3; @FXML Label label4; @FXML Label label5;
        @FXML Label label6;
    //Structures
    private Heap heap = new Heap();
    private Label[] labels = new Label[]{ label0, label1, label2, label3, label4, label5, label6 };
    //Utility methods
    public void render(){
        int[] elements = heap.getArray();
        for(int i = 0; i < elements.length; i++) {
            labels[i].setText(Integer.toString(elements[i]));
        }
        for(int i = elements.length; i < MAX_SIZE; i++){
            labels[i].setText("");
        }
    }
    public void initialize(){
        labels = new Label[MAX_SIZE];
        labels[0] = label0; labels[1] = label1; labels[2] = label2;
        labels[3] = label3; labels[4] = label4; labels[5] = label5;
        labels[6] = label6;
    }

    public void onAddButtonClick(){
        int valueToAdd = Integer.parseInt(textField.getText());
        heap.add(valueToAdd);
        render();
    }
    public void onRemoveButtonClick(){
        heap.remove();
        render();
    }
}
