// rdmello
package edu.syr.hw5;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class StackImplementation<E> implements Stack<E> {
    private final List<E> list;

    public StackImplementation(List<E> list) {
        this.list = list;
    }

    @Override
    public void push(E e) {
        list.add(e);
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        int lastIndex = list.size() - 1;
        E element = list.get(lastIndex);
        list.remove(lastIndex);
        return element;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return list.get(list.size() - 1);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public List<E> getData() {
        // Return an unmodifiable view of the list
        return Collections.unmodifiableList(list);
    }

    private boolean isEmpty() {
        return list.isEmpty();
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new StackImplementation<>(new ArrayList<>());
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Stack size: " + stack.size());
        System.out.println("Stack peek: " + stack.peek());

        System.out.println("Stack pop: " + stack.pop());
        System.out.println("Stack size after pop: " + stack.size());

        System.out.println("Stack data: " + stack.getData());
    }
}
