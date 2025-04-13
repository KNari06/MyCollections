package mylists;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<E> implements MyList<E> {
    private class Node {
        E data;
        Node next;
        Node prev;

        Node(E data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public void add(E element) {
        Node newNode = new Node(element);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public void add(int index, E element) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();

        if (index == size) {
            add(element);
            return;
        }

        Node newNode = new Node(element);
        Node current = getNode(index);

        newNode.next = current;
        newNode.prev = current.prev;

        if (current.prev != null) current.prev.next = newNode;
        else head = newNode;

        current.prev = newNode;

        size++;
    }

    public E get(int index) {
        return getNode(index).data;
    }

    public E remove(int index) {
        Node toRemove = getNode(index);
        if (toRemove.prev != null) toRemove.prev.next = toRemove.next;
        else head = toRemove.next;

        if (toRemove.next != null) toRemove.next.prev = toRemove.prev;
        else tail = toRemove.prev;

        size--;
        return toRemove.data;
    }

    public boolean remove(E element) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(element)) {
                if (current.prev != null) current.prev.next = current.next;
                else head = current.next;

                if (current.next != null) current.next.prev = current.prev;
                else tail = current.prev;

                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public boolean contains(E element) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(element)) return true;
            current = current.next;
        }
        return false;
    }

    public void clear() {
        head = tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int indexOf(E element) {
        Node current = head;
        int index = 0;
        while (current != null) {
            if (current.data.equals(element)) return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    private Node getNode(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();

        Node current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) current = current.next;
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) current = current.prev;
        }
        return current;
    }

    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node current = head;

            public boolean hasNext() {
                return current != null;
            }

            public E next() {
                if (!hasNext()) throw new NoSuchElementException();
                E data = current.data;
                current = current.next;
                return data;
            }
        };
    }
}
