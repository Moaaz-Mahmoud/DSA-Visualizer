package com.example.dsavisualizer;

public class Heap {
    private static final int MAX_SIZE = 7;
    private int[] data;
    private int size;

    //Constructor
    public Heap(){
        data = new int[MAX_SIZE];
        size = 0;
    }
    //Utility methods
    protected void swap(Integer x, Integer y){
        int temp = x; x = y; y = temp;
    }
    protected void upwardRebuild(int idx){
        if(idx == 0) return;
        int parentIdx = (idx-1)/2;
        if(data[parentIdx] < data[idx]){
            int temp = data[idx]; data[idx] = data[parentIdx]; data[parentIdx] = temp;
            upwardRebuild(parentIdx);
        }
    }
    protected void downwardRebuild(int idx){
        int leftChildIdx = idx*2+1, rightChildIdx = idx*2+2;
        if(leftChildIdx >= size) return;
        if(data[idx] < data[idx*2+1]) {
            int temp = data[idx]; data[idx] = data[leftChildIdx]; data[leftChildIdx] = temp;
            downwardRebuild(leftChildIdx);
        }
        if(rightChildIdx >= size) return;
        if(data[idx] < data[rightChildIdx]){
            int temp = data[idx]; data[idx] = data[rightChildIdx]; data[rightChildIdx] = temp;
            downwardRebuild(rightChildIdx);
        }
    }
    //Main methods
    public void add(int element){
        if(size == data.length) return;
        data[size] = element;
        size++;
        upwardRebuild(size-1);
    }
    public void remove(){
        if(size == 0) return;
        data[0] = data[size-1];
        size--;
        downwardRebuild(0);
    }
    //Useful for visualization
    public int[] getArray(){
        int[] arr = new int[size];
        for(int i = 0; i < size; i++)
            arr[i] = data[i];
        return arr;
    }
}
