package org.example;

public class Main {
    public static void main( String[] args) {

        LinkedList myList = new LinkedList(1);
        myList.append(2);
        myList.append(3);
        myList.append(4);
        myList.append(5);

        System.out.println("inside the method");
        System.out.println(myList.findKthFromEnd(2).value);
    }

}