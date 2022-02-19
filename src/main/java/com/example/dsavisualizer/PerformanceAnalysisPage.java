package com.example.dsavisualizer;

import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

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
    @FXML Label ImplementationSpecifierAlert;
    @FXML Button exportCSVButton;

    private XYChart.Series series;

    //Controller methods
    //Stack
    public void onStackInsertButtonClick(){
        if(stackImplSpecifier.getValue() == null){
            ImplementationSpecifierAlert.setText("Please specify an implementation!");
        }
        else if(stackImplSpecifier.getValue().equals("Array-Based")){
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
            ImplementationSpecifierAlert.setText("");
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
            ImplementationSpecifierAlert.setText("");
            displayCurve(times);
        }
    }
    public void onStackRemoveButtonClick(){
        if(stackImplSpecifier.getValue() == null){
            ImplementationSpecifierAlert.setText("Please specify an implementation!");
        }
        else if(stackImplSpecifier.getValue().equals("Array-Based")){
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
            ImplementationSpecifierAlert.setText("");
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
            ImplementationSpecifierAlert.setText("");
            displayCurve(times);
        }
    }
    //Queue
    public void onQueueInsertButtonClick(){
        if(queueImplSpecifier.getValue() == null){
            ImplementationSpecifierAlert.setText("Please specify an implementation!");
        }
        else if (queueImplSpecifier.getValue().equals("Array-Based")) {
            ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
            long[] times = new long[8];
            arrayQueue.add(5); //Dummy operation for optimizations
            long startTime, endTime;
            for (int operationCount = 1, pass = 0; operationCount <= (int) 1e7; operationCount *= 10, pass++) {
                arrayQueue = new ArrayQueue<>();
                startTime = System.nanoTime();
                for (int operationNumber = 0; operationNumber < operationCount; operationNumber++) {
                    arrayQueue.add(operationNumber);
                }
                endTime = System.nanoTime();
                times[pass] = endTime - startTime;
            }
            ImplementationSpecifierAlert.setText("");
            displayCurve(times);
        } else if (queueImplSpecifier.getValue().equals("Link-Based")) {
            LinkedQueue<Integer> linkedQueue = new LinkedQueue<>();
            long[] times = new long[8];
            linkedQueue.add(5); //Dummy operation for optimizations
            long startTime, endTime;
            for (int operationCount = 1, pass = 0; operationCount <= (int) 1e7; operationCount *= 10, pass++) {
                linkedQueue = new LinkedQueue<>();
                startTime = System.nanoTime();
                for (int operationNumber = 0; operationNumber < operationCount; operationNumber++) {
                    linkedQueue.add(operationNumber);
                }
                endTime = System.nanoTime();
                times[pass] = endTime - startTime;
            }
            ImplementationSpecifierAlert.setText("");
            displayCurve(times);
        }

    }
    public void onQueueRemoveButtonClick(){
        if(queueImplSpecifier.getValue() == null){
            ImplementationSpecifierAlert.setText("Please specify an implementation!");
        }
        else if(queueImplSpecifier.getValue().equals("Array-Based")){
            ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
            long[] times = new long[8];
            arrayQueue.add(5); //Dummy operation for optimizations
            long startTime, endTime;
            for(int operationCount = 1, pass = 0; operationCount <= (int)1e7; operationCount *= 10, pass++){
                arrayQueue = new ArrayQueue<>();
                for(int operationNumber = 0; operationNumber < operationCount; operationNumber++){
                    arrayQueue.add(operationNumber);
                }
                startTime = System.nanoTime();
                for(int operationNumber = 0; operationNumber < operationCount; operationNumber++){
                    arrayQueue.remove();
                }
                endTime = System.nanoTime();
                times[pass] = endTime-startTime;
            }
            ImplementationSpecifierAlert.setText("");
            displayCurve(times);
        }
        else if(queueImplSpecifier.getValue().equals("Link-Based")){
            LinkedQueue<Integer> linkedQueue = new LinkedQueue<>();
            long[] times = new long[8];
            linkedQueue.add(5); //Dummy operation for optimizations
            long startTime, endTime;
            for(int operationCount = 1, pass = 0; operationCount <= (int)1e7; operationCount *= 10, pass++){
                linkedQueue = new LinkedQueue<>();
                for(int operationNumber = 0; operationNumber < operationCount; operationNumber++){
                    linkedQueue.add(operationNumber);
                }
                startTime = System.nanoTime();
                for(int operationNumber = 0; operationNumber < operationCount; operationNumber++){
                    linkedQueue.remove();
                }
                endTime = System.nanoTime();
                times[pass] = endTime-startTime;
            }
            ImplementationSpecifierAlert.setText("");
            displayCurve(times);
        }
    }
    //Heap
    public void onHeapInsertButtonClick(){
        Heap heap = new Heap();
        long[] times = new long[8];
        heap.add(5); //Dummy operation for optimizations
        long startTime, endTime;
        for(int operationCount = 1, pass = 0; operationCount <= (int)1e7; operationCount *= 10, pass++){
            heap = new Heap();
            startTime = System.nanoTime();
            for(int operationNumber = 0; operationNumber < operationCount; operationNumber++){
                heap.add(operationNumber);
            }
            endTime = System.nanoTime();
            times[pass] = endTime-startTime;
        }
        displayCurve(times);
    }
    public void onHeapRemoveButtonClick(){
        Heap heap = new Heap();
        long[] times = new long[8];
        heap.add(5); //Dummy operation for optimizations
        long startTime, endTime;
        for(int operationCount = 1, pass = 0; operationCount <= (int)1e7; operationCount *= 10, pass++){
            heap = new Heap();
            startTime = System.nanoTime();
            for(int operationNumber = 0; operationNumber < operationCount; operationNumber++){
                heap.add(operationNumber);
            }
            for(int operationNumber = 0; operationNumber < operationCount; operationNumber++){
                heap.remove();
            }
            endTime = System.nanoTime();
            times[pass] = endTime-startTime;
        }
        displayCurve(times);
    }

    //Export to CSV
    public void onExportCSVButtonClick() throws IOException {
        if(!visualizationChart.getData().isEmpty()){
//            CSVIO.writeCSV(visualizationChart.getData());
            ArrayList<String[]> contentToWrite = new ArrayList<>();
            for(var entry : series.getData()){
                var row = entry.toString();
                row = row.substring(5, row.length()-6);
                contentToWrite.add(row.split(","));
            }
            CSVIO.writeCSV(contentToWrite, "results.csv");
        }
        else{
            ImplementationSpecifierAlert.setText("Please make a plot first!");
        }
    }

    //Other essential methods
    public void initialize(){

    }
    public void displayCurve(long[] yData){
        long[] xData = new long[]{1, 10, 100, 1000, 10000, 100000, 1000000};
        series = new XYChart.Series();
        for(int i = 0; i < Math.min(xData.length, yData.length); i++){
            series.getData().add(
                    new XYChart.Data(xData[i], yData[i])
            );
        }
        visualizationChart.getData().clear();
        visualizationChart.getData().add(series);
    }
}
