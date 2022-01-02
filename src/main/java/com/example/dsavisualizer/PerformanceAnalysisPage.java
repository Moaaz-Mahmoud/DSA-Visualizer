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
    @FXML LogarithmicAxis plotXAxis;
    @FXML LogarithmicAxis plotYAxis;
    @FXML LineChart visualizationChart;

    //Controller methods
    //List
    public void onListInsertButtonClick(){
        System.out.println("List");
        long[] x = new long[]{1, 2, 3};
        long[] y = new long[]{1, 3, 2};
        displayCurve(y);
    }
    public void onListRemoveButtonClick(){
        System.out.println("List");
        long[] x = new long[]{1, 2, 3};
        long[] y = new long[]{1, 2, 3};
        displayCurve(y);
    }
    //Stack
    public void onStackInsertButtonClick(){
        if(stackImplSpecifier.getValue().equals("Array-Based")){
            ArrayStack<Integer> arrayStack = new ArrayStack<>();
            long[] times = new long[8];
            arrayStack.push(5); //Dummy operation for optimizations
            long startTime, endTime;
            for(int operationCount = 1, pass = 0; operationCount <= (int)1e7; operationCount *= 10, pass++){
                arrayStack = new ArrayStack<>();
                startTime = System.nanoTime();
                for(int operationNumber = 0; operationNumber < operationCount; operationNumber++){
                    arrayStack.push(operationNumber);
                }
                endTime = System.nanoTime();
                times[pass] = endTime-startTime;
            }
            displayCurve(times);
        }
        else if(stackImplSpecifier.getValue().equals("Link-Based")){
            LinkedStack<Integer> linkedStack = new LinkedStack<>();
            long[] times = new long[8];
            linkedStack.push(5); //Dummy operation for optimizations
            long startTime, endTime;
            for(int operationCount = 1, pass = 0; operationCount <= (int)1e7; operationCount *= 10, pass++){
                linkedStack = new LinkedStack<>();
                startTime = System.nanoTime();
                for(int operationNumber = 0; operationNumber < operationCount; operationNumber++){
                    linkedStack.push(operationNumber);
                }
                endTime = System.nanoTime();
                times[pass] = endTime-startTime;
            }
            displayCurve(times);
        }
    }
    public void onStackRemoveButtonClick(){
        if(stackImplSpecifier.getValue().equals("Array-Based")){
            ArrayStack<Integer> arrayStack = new ArrayStack<>();
            long[] times = new long[8];
            arrayStack.push(5); //Dummy operation for optimizations
            long startTime, endTime;
            for(int operationCount = 1, pass = 0; operationCount <= (int)1e7; operationCount *= 10, pass++){
                arrayStack = new ArrayStack<>();
                for(int operationNumber = 0; operationNumber < operationCount; operationNumber++){
                    arrayStack.push(operationNumber);
                }
                startTime = System.nanoTime();
                for(int operationNumber = 0; operationNumber < operationCount; operationNumber++){
                    arrayStack.pop();
                }
                endTime = System.nanoTime();
                times[pass] = endTime-startTime;
            }
            displayCurve(times);
        }
        else if(stackImplSpecifier.getValue().equals("Link-Based")){
            LinkedStack<Integer> linkedStack = new LinkedStack<>();
            long[] times = new long[8];
            linkedStack.push(5); //Dummy operation for optimizations
            long startTime, endTime;
            for(int operationCount = 1, pass = 0; operationCount <= (int)1e7; operationCount *= 10, pass++){
                linkedStack = new LinkedStack<>();
                for(int operationNumber = 0; operationNumber < operationCount; operationNumber++){
                    linkedStack.push(operationNumber);
                }
                startTime = System.nanoTime();
                for(int operationNumber = 0; operationNumber < operationCount; operationNumber++){
                    linkedStack.pop();
                }
                endTime = System.nanoTime();
                times[pass] = endTime-startTime;
            }
            displayCurve(times);
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
    public void displayCurve(long[] yData){
        long[] xData = new long[]{1, 10, 100, 1000, 10000, 100000, 1000000};
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
