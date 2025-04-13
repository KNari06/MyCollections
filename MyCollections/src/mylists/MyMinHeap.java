package mylists;

public class MyMinHeap<E extends Comparable<E>> {
    private MyArrayList<E> heap = new MyArrayList<>();

    public void add(E element) {
        heap.add(element);
        heapifyUp();
    }

    public E poll() {
        if (heap.isEmpty()) throw new IllegalStateException("Heap is empty");
        E min = heap.get(0);
        E last = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.add(0, last);
            heapifyDown();
        }
        return min;
    }

    public E peek() {
        if (heap.isEmpty()) throw new IllegalStateException("Heap is empty");
        return heap.get(0);
    }

    private void heapifyUp() {
        int index = heap.size() - 1;
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heap.get(index).compareTo(heap.get(parent)) >= 0) break;
            swap(index, parent);
            index = parent;
        }
    }

    private void heapifyDown() {
        int index = 0;
        int size = heap.size();
        while (index < size) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int smallest = index;

            if (left < size && heap.get(left).compareTo(heap.get(smallest)) < 0) smallest = left;
            if (right < size && heap.get(right).compareTo(heap.get(smallest)) < 0) smallest = right;
            if (smallest == index) break;
            swap(index, smallest);
            index = smallest;
        }
    }

    private void swap(int i, int j) {
        E temp = heap.get(i);
        heap.add(i, heap.get(j));
        heap.add(j, temp);
        heap.remove(i + 1);
        heap.remove(j + 1);
    }

    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }
}
