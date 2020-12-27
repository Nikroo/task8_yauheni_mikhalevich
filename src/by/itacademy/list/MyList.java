package by.itacademy.list;

import java.util.*;

public interface MyList<T> extends Iterable<T> {

    boolean add(T obj);
    void add(int index, T obj);
    boolean addAll(int index, Collection<? extends T> col);
    T get(int index);
    int indexOf(Object obj);
    int lastIndexOf(Object obj);
    Iterator<T> iterator ();
    T remove(int index);
    T set(int index, T obj);
    void sort(Comparator<? super T> comp);
    MyList<T> subList(int start, int end);
    int size();
}
