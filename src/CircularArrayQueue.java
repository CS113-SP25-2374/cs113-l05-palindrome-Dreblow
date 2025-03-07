

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

public class CircularArrayQueue<E> implements Queue<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private E[] array;
    private int front;
    private int rear;
    private int size;

    @SuppressWarnings("unchecked")
    public CircularArrayQueue() {
        array = (E[]) new Object[DEFAULT_CAPACITY];
        front = 0;
        rear = -1;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        int index = front;
        for (int i = 0; i < size; i++) {
            if (array[index].equals(o)) {
                return true;
            }
            index = (index + 1) % array.length;
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }

    @Override
    public Object[] toArray() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toArray'");
    }

    @Override
    public <T> T[] toArray(T[] a) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toArray'");
    }

    @Override
    public boolean remove(Object o) {
        if (size == 0) return false;
    
        int index = front;
        for (int i = 0; i < size; i++) {
            if (array[index].equals(o)) {
                // Shift elements left after removing
                for (int j = i; j < size - 1; j++) {
                    array[index] = array[(index + 1) % array.length];
                    index = (index + 1) % array.length;
                }
    
                array[rear] = null;
                rear = (rear - 1 + array.length) % array.length;
                size--;
                return true;
            }
            index = (index + 1) % array.length;
        }
        return false; // Element not found
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'containsAll'");
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addAll'");
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeAll'");
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'retainAll'");
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'clear'");
    }

    @Override
    public boolean add(E e) {
        if (size == array.length) {
            throw new IllegalStateException("Queue is full");
        }
        return offer(e);
    }

    @Override
    public boolean offer(E e) {
        if (size == array.length) {
            resize(array.length * 2);
        }

        rear = (rear + 1) % array.length;
        array[rear] = e;
        size++;
        return true;
    }

    @Override
    public E remove() {
        if (size == 0) {
            throw new NoSuchElementException("Queue is empty");
        }
        return poll();
    }

    @Override
    public E poll() {
        if (size == 0) {
            return null;
        }
    
        E element = array[front];
        array[front] = null; // Prevent memory leaks
        front = (front + 1) % array.length;
        size--;
    
        return element;
    }

    @Override
    public E element() {
        if (size == 0) {
            throw new NoSuchElementException("Queue is empty");
        }
        return array[front];
    }

    @Override
    public E peek() {
        return (size == 0) ? null : array[front];
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        int index = front;
        for (int i = 0; i < size; i++) {
            sb.append(array[index]);
            if (i < size - 1) {
                sb.append(", ");
            }
            index = (index + 1) % array.length;
        }
        sb.append("]");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        E[] newArray = (E[]) new Object[newCapacity];

        int index = front;
        for (int i = 0; i < size; i++) {
            newArray[i] = array[index];
            index = (index + 1) % array.length; // Move in circular fashion
        }

        array = newArray;
        front = 0;
        rear = size - 1;
    }
    
}
