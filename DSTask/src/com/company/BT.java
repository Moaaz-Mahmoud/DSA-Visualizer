package com.company;

public class BT {
    BTNode root;
    public BT (int data){
        root = new BTNode(data, null, null);
    }
    public void addNode(int element){
        recAdd(root, element);
    }
    protected BTNode recAdd(BTNode start, int element){
        if (start == null)
            start =new BTNode(element, null,null);
        else if (element > (int)start.getData())
            start.setRightNode(recAdd(start.getRightNode(), element));
        else
            start.setLeftNode(recAdd(start.getLeftNode(), element));
        return start;
    }
    public void display(){
        root.InOrderPrint();
    }
}
