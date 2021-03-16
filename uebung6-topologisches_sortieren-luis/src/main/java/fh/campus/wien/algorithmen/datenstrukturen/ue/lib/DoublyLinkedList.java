/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fh.campus.wien.algorithmen.datenstrukturen.ue.lib;

/**
 * @author Luis
 */
public class DoublyLinkedList {

    public int count;
    public Leaf head;
    public Leaf tail;

    public DoublyLinkedList() {
        count = 0;
        head = tail = null;
    }


    public void insertEnd(Node n) {

        Leaf actualNode = new Leaf(n);
        if (this.count == 0) {
            this.head = actualNode;
            this.tail = actualNode;
            this.count++;
            return;
        }

        Leaf found = find(n.endTime);
        if (found != null) {
            System.err.println("Der knoten existiert schon. Sie dürfen diesen Knoten nicht einfügen");
            return;

        }

        actualNode.prev = this.tail;
        this.tail.next  = actualNode;
        this.tail = actualNode;

        this.count++;

    }


    public Leaf find(int key) {

        Leaf actualNode = this.head;
        while (actualNode != null) {

            if (actualNode.key == key) {
                return actualNode;
            }

            actualNode = actualNode.next;
        }

        return null;
    }

    public void print(boolean isASC) {
        if (this.head == null) {
            System.err.println("Die Liste ist leer.");
            return;
        }
        Leaf actualNode = this.head;
        if(!isASC)
            actualNode = this.tail;

        while (actualNode != null) {
            System.out.print(String.format("%s",actualNode.n.name));

            if(isASC)
                actualNode = actualNode.next;
            else
                actualNode = actualNode.prev;

            if(actualNode != null)
                System.out.print(" -> ");
        }

        System.out.println();

    }

}
