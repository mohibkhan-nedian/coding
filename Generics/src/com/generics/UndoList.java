package com.generics;

import java.util.*;

interface Undoable{
    void undo();
}
interface UndoAction {
    void execute();
}

public class UndoList<T> implements List<T>, Undoable, Iterable<T> {
    private final List<T> list;
    private final Stack<UndoAction> undoActionStack = new Stack<>();

    class UndoInsertAction<T> implements UndoAction {

        private T item;

        public UndoInsertAction(T item) {
            this.item = item;
        }

        @Override
        public void execute() {
            list.remove(item);
        }
    }

    class UndoDeleteAction implements UndoAction {

        private Object element;

        public UndoDeleteAction(Object element) {
            this.element = element;
        }

        @Override
        public void execute() {
            list.add((T) element);
        }
    }
    public UndoList(List<T> list) {
        this.list = list;
    }

    @Override
    public void undo() {
        undoActionStack.pop().execute();
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }

    public SkipIterator<T> skipIterator() {
        return new UndoListIterator();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        undoActionStack.add(new UndoInsertAction(t));
        return list.add(t);
    }

    @Override
    public boolean remove(Object o) {
        undoActionStack.add(new UndoDeleteAction(o));
        return list.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public void add(int index, T element) {

    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    interface SkipIterator<T> extends Iterator<T> {
        public void skip();
    }
    private class UndoListIterator implements SkipIterator<T> {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public T next() {
            return null;
        }

        public void skip() {
            //just move the cursor ahead
            next();
        }
    }
}
