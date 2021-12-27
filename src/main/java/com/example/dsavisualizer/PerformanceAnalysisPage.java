package com.example.dsavisualizer;

import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
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
    @FXML NumberAxis plotXAxis;
    @FXML NumberAxis plotYAxis;
    @FXML LineChart visualizationChart;

    //Controller methods
    //List
    public void onListInsertButtonClick(){
        System.out.println("List");
        int[] x = new int[]{1, 2, 3};
        int[] y = new int[]{1, 3, 2};
        displayCurve(x, y);
    }
    public void onListRemoveButtonClick(){
        System.out.println("List");
        int[] x = new int[]{1, 2, 3};
        int[] y = new int[]{1, 2, 3};
        displayCurve(x, y);
    }
    //Stack
    public void onStackInsertButtonClick(){
        if(stackImplSpecifier.getValue().equals("Array-Based")){
            ArrayStack<Integer> arrayStack = new ArrayStack<>();
            arrayStack.push(5); //Dummy operation for optimizations
            for(int operationCount = 1; operationCount < (int)1e6; operationCount *= 10){
                arrayStack = new ArrayStack<>();
            }
            //{1, 10, 100, ..., 1e6}
            //{t1, t10, t100, ...,  }
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
    public void displayCurve(int[] xData, int[] yData){
        XYChart.Series series = new XYChart.Series();
        for(int i = 0; i < Math.min(xData.length, yData.length); i++){
            series.getData().add(
                    new XYChart.Data(xData[i], yData[i])
            );
        }
        visualizationChart.getData().clear();
        visualizationChart.getData().add(series);
    }
}
