package com.stack;

/**
 * User: edward
 * Date: 10/8/13
 * Time: 2:43 PM
 */
public class Stack {
    private Object[] elements;
    private int size = 0;
    private int AddSize = 0;

    public Stack(int initalSize) {
        elements = new Object[initalSize];
    }

    public Stack(int initalSize, int AddSize) {
        this(initalSize);
        this.AddSize = AddSize;
    }

    private void forwardAdd() {
        //decide when to add
        if (elements.length == size) {
            Object[] _element = elements;
            int newLength = 0;
            if (AddSize > 0) {
                newLength = elements.length + AddSize;
            } else {
                newLength = (int) (elements.length * 1.5);
            }
            elements = new Object[newLength];
            System.arraycopy(_element, 0, elements, 0, size);
        }
    }

    public void push(Object object) {
        forwardAdd();
        elements[size++] = object;
    }

    public Object pop() {
        if (size == 0) {
            throw new RuntimeException("empty stack");
        }
        return elements[--size];
    }

    public int size() {
        return size;
    }

}
