package Palindrome;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class ArrayListStack<E> implements StackInterface<E> {
    private final ArrayList<E> array;
    private int top; 

    public ArrayListStack() {
        array = new ArrayList<>(); 
        top = -1; 
    }

    @Override
    public boolean empty() {
        return top == -1;
    }

    @Override
    public E push(E obj) {
        array.add(obj);
        top++;
        return obj;
    }

    @Override
    public E pop() {
        if (empty()) {
            throw new EmptyStackException();
        }
        E element = array.remove(top);
        top--;
        return element;
    }

    @Override
    public E peek() {
        if (empty()) {
            throw new EmptyStackException();
        }
        return array.get(top);
    }

    public int size() {
        return top + 1;
    }

    @Override
    public String toString() {
        return array.toString();
    }
}
