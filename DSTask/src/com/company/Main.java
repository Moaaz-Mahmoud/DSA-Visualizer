package com.company;

public class Main {

    public static void main(String[] args) {
        int counter = 1;
        while (counter < 100000000)
        {
        BT tree = new BT(20);
        long start = System.nanoTime();
        for (int i = 0; i < counter; i++)
            tree.addNode((int) (Math.random()*1E5));
        long end = System.nanoTime();
        //if(counter != 1)
            //System.out.println("Start = " + start + "\nEnd = " + end);
            System.out.println(counter + " = " + (end-start) + " s");
        counter *= 10;
        }
    }
}
