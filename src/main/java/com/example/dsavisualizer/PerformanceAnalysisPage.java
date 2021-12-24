package com.example.dsavisualizer;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.control.*;

public class PerformanceAnalysisPage extends Controller{
    //Controls
    //List
    @FXML Button listInsertButton;@FXML Button listRemoveButton;
    //Stack
    @FXML private ComboBox<String> stackImplSpecifier;
    @FXML Button stackInsertButton; @FXML Button stackRemoveButton;
    //Queue
    @FXML private ComboBox<String> queueImplSpecifier;
    @FXML Button queueInsertButton; @FXML Button queueRemoveButton;
    //Heap
    @FXML Button heapInsertButton; @FXML Button heapRemoveButton;
    //General
    @FXML LineChart visualizationChart;

    //Controller methods
    //List
    public void onListInsertButtonClick(){
        System.out.println("List");
    }
    public void onListRemoveButtonClick(){
        System.out.println("List");
    }
    //Stack
    public void onStackInsertButtonClick(){
        if(stackImplSpecifier.getValue().equals("Array-Based")){
            System.out.println("Array-Based");
        }
        else if(stackImplSpecifier.getValue().equals("Link-Based")){
            System.out.println("Link-Based");
        }
    }
    public void onStackRemoveButtonClick(){
        if(stackImplSpecifier.getValue().equals("Array-Based")){
            System.out.println("Array-Based");
        }
        else if(stackImplSpecifier.getValue().equals("Link-Based")){
            System.out.println("Link-Based");
        }
    }
    //Queue
    public void onQueueInsertButtonClick(){
        if(queueImplSpecifier.getValue().equals("Array-Based")){
            System.out.println("Array-Based");
        }
        else if(queueImplSpecifier.getValue().equals("Link-Based")){
            System.out.println("Link-Based");
        }
    }
    public void onQueueRemoveButtonClick(){
        if(queueImplSpecifier.getValue().equals("Array-Based")){
            System.out.println("Array-Based");
        }
        else if(queueImplSpecifier.getValue().equals("Link-Based")){
            System.out.println("Link-Based");
        }
    }
    //Heap
    public void onHeapInsertButtonClick(){
        System.out.println("Heap");
    }
    public void onHeapRemoveButtonClick(){
        System.out.println("Heap");
    }

    //Other essential methods
    public void initialize(){

    }
    public void render(){

    }
}
