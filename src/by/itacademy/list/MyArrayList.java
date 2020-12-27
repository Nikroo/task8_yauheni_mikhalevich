package by.itacademy.list;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

public class MyArrayList<T> implements MyList<T> {

    private Collection<? extends T> col;
    private Object[] array;
    private Object[] tempArray;
    private static final int CAPACITY = 10;

    public MyArrayList() {
        this.array = new Object[CAPACITY];
    }

    public MyArrayList(int capacity) {
        this.array = new Object[capacity];
    }

    public MyArrayList(Collection<? extends T> col) {
        array = col.toArray();
    }

    public boolean add(T obj) {
        for (int i = 0; i <= array.length; i++) {
            if (size() == array.length) {
                riseArray();
            }
            if (array[i] == null) {
                array[i] = obj;
                return true;
            }
        }
        return false;
    }

    @Override
    public void add(int index, T obj) {
        checkCapacity(index);

        tempArray = new Object[array.length];
        tempArray[index] = obj;
        for (int i = 0; i < index; i++) {
            tempArray[i] = array[i];
        }
        for (int i = index; i < size(); i++) {
            tempArray[i + 1] = array[i];
        }
        array = tempArray;
    }


    @Override
    public T remove(int index) {
        checkCapacity(index);

        tempArray = new Object[array.length];
        T obj = get(index);

        tempArray = new Object[array.length];
        for (int i = 0; i < index; i++) {
            tempArray[i] = array[i];
        }
        for (int i = index; i < size(); i++) {
            tempArray[i] = array[i + 1];
        }
        array = tempArray;
        return obj;
    }

    @Override
    public T set(int index, T obj) {
        T object = get(index);
        array[index] = obj;
        return object;
    }

    @Override
    public void sort(Comparator<? super T> comp) {
        for (int i = size() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if ((comp.compare((T) array[i], (T) array[j])) < 1) {
                    Object temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
    }

    @Override
    public MyList<T> subList(int start, int end) {
        MyList<T> mySubArrayList = new MyArrayList<>();
        for (int i = start; i < end; i++) {
            mySubArrayList.add((T) array[i]);
        }
        return mySubArrayList;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> col) {
        Object[] subArray = col.toArray();
        if (subArray.length == 0) {
            return false;
        }
        for (int i = 0; i < col.size(); i++) {
            add(index, (T) subArray[i]);
            index++;
        }
        return true;
    }

    @Override
    public T get(int index) {
        return (T) array[index];
    }

    @Override
    public int indexOf(Object obj) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null && array[i].equals(obj)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object obj) {
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] != null && array[i].equals(obj)) {
                return i;
            }
        }
        return -1;
    }

    public static MyList of(Object... objects) {
        MyList<Object> l = new MyArrayList<>();
        for (Object t : objects) {
            l.add(t);
        }
        return l;
    }

    public int size() {
        int size = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                size++;
            }
        }
        return size;
    }

    private void checkCapacity(int index) {
        if (size() < index || index < 0) {
            throw new ArrayIndexOutOfBoundsException("ArrayIndexOutOfBoundsException");
        } else {
            if (size() == array.length) {
                riseArray();
            }
        }
    }

    private void riseArray() {
        tempArray = new Object[array.length];
        tempArray = array;
        array = new Object[array.length + array.length / 2];
        for (int i = 0; i < tempArray.length; i++) {
            array[i] = tempArray[i];
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {


        private int currentIndex;

        @Override
        public boolean hasNext() {
            return currentIndex < size();
        }

        @Override
        public T next() {
            return (T) array[currentIndex++];
        }
    }
}
