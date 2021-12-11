package com.example.dsavisualizer;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;

//import static jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyle.circle;

public class HeapPage extends Controller{
    //Constants
    private final int MAX_SIZE = 7;
    //Layout components
    @FXML TextField textField;
    @FXML Button addButton;
    @FXML Button removeButton;
    @FXML Label label0; @FXML Label label1; @FXML Label label2;
    @FXML Label label3; @FXML Label label4; @FXML Label label5;
    @FXML Label label6;
    @FXML Circle circle0; @FXML Circle circle1; @FXML Circle circle2;
    @FXML Circle circle3; @FXML Circle circle4; @FXML Circle circle5;
    @FXML Circle circle6;
    //Structures
    private Heap heap = new Heap();
    private Label[] labels = new Label[]{ label0, label1, label2, label3, label4, label5, label6 };
    private Circle[] circles = new Circle[]{circle0, circle1, circle2, circle3, circle4, circle5, circle6};
    //Utility methods
    public void render(){
        //initialize();
        int[] elements = heap.getArray();
        for(int i = 0; i < elements.length; i++) {
            labels[i].setText(Integer.toString(elements[i]));
        }
        for(int i = elements.length; i < MAX_SIZE; i++){
            labels[i].setText("");
        }
        for(int i = 0; i < elements.length; i++){
            circles[i].setVisible(true);
        }
        for(int i = elements.length; i < MAX_SIZE; i++){
            circles[i].setVisible(false);
        }
    }
    public void initialize(){
        labels = new Label[MAX_SIZE];
        labels[0] = label0; labels[1] = label1; labels[2] = label2;
        labels[3] = label3; labels[4] = label4; labels[5] = label5;
        labels[6] = label6;
        circles = new Circle[MAX_SIZE];
        circles[0] = circle0; circles[1] = circle1; circles[2] = circle2;
        circles[3] = circle3; circles[4] = circle4; circles[5] = circle5;
        circles[6] = circle6;
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
