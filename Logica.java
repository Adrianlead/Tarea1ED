package com.company;

import java.util.Iterator;
import java.util.NoSuchElementException;

//Obtenido de Internet

public class Logica<Item> implements Iterable<Item> {
    private int n;
    private Node first;

    private class Node {
        private Item item;
        private Node next;
    }

    public Logica() {
        first = null;
        n = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public void push(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        n++;
    }

    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = first.item;        // save item to return
        first = first.next;            // delete first node
        n--;
        return item;                   // return the saved item
    }

    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return first.item;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item);
            s.append(' ');
        }
        return s.toString();
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    //----------------------------------------------------------------------------------------------------------//

    public String[] data = new String[50];
    public int head;
    public int tail;
    ;

    public void Cola(int tamaño) {
        this.data = new String[tamaño];
        this.head = 0;
        this.tail = 0;

    }

    public void enqueue(String line) {
        this.data[tail] = line;
        this.tail = this.tail + 1;
    }

    public String dequeue() {
        String dato = this.data[head];
        this.head = this.head + 1;
        return dato;

    }

    public void printStatus() {
        System.out.println("Head: " + this.head + ", Tail: " + this.tail);
        System.out.println(data[0]);
    }

    public String first() {
        return data[head];
    }
}
