package mylists;

public class MyStack<E> {
    private MyArrayList<E> list = new MyArrayList<>();

    public void push(E element) {
        list.add(element);
    }

    public E pop() {
        if (list.isEmpty()) throw new IllegalStateException("Stack is empty");
        return list.remove(list.size() - 1);
    }

    public E peek() {
        if (list.isEmpty()) throw new IllegalStateException("Stack is empty");
        return list.get(list.size() - 1);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }
}