package ss10_arraylist_linkedlist.exercise.build_arraylist_library;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        boolean isValidCapacity = capacity > 0;
        if (isValidCapacity) {
            elements = new Object[capacity];
        } else {
            System.out.println("Capacity must be greater than zero");
        }
    }

    private void ensureCapacity() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    public int size() {
        int countNotNullObjects = 0;
        for (Object object : elements) {
            if (object != null) {
                countNotNullObjects++;
            }
        }
        return size = countNotNullObjects;
    }

    public boolean add(E element) {
        if (size() == elements.length) {
            ensureCapacity();
        }
        elements[size++] = element;
        return true;
    }

    public void add(int index, E element) {
        boolean isValidIndex = index <= size() && index >= 0;
        if (isValidIndex) {
            add(element);
            for (int i = size() - 1; i > index; i--) {
                Object cacheVariable = elements[i - 1];
                elements[i - 1] = elements[i];
                elements[i] = cacheVariable;
            }
        } else {
            System.out.println("Index out of range");
        }
    }

    public E remove(int index) {
        boolean isValidIndex = index < size() && index >= 0;
        E saveRemoveObject = (E) elements[index];
        if (isValidIndex) {
            elements[index] = null;
            for (int i = index; i < size(); i++) {
                Object cacheVariable = elements[i + 1];
                elements[i + 1] = elements[i];
                elements[i] = cacheVariable;
            }

        } else {
            System.out.println("Index out of range");
        }
        return saveRemoveObject;
    }

    public Object clone() {
        return new MyList<>(elements.length);
    }

    public boolean contains(E o) {
        for (Object element : elements) {
            if (element.equals(o)) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(E o) {
        for (int i = 0; i < size(); i++) {
            if (elements[i] == o) {
                return i;
            }
        }
        return -1;
    }

    public void ensureCapacity(int minCapacity) {
        if (minCapacity > elements.length) {
            ensureCapacity();
        }
    }

    public E get(int index) {
        return (E) elements[index];
    }

    public void clear() {
        elements = new Object[elements.length];
    }
}
