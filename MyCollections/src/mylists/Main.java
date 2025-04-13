package mylists;

public class Main {
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(10);
        stack.push(20);
        System.out.println("Stack pop: " + stack.pop());

        MyQueue<String> queue = new MyQueue<>();
        queue.enqueue("A");
        queue.enqueue("B");
        System.out.println("Queue dequeue: " + queue.dequeue());

        MyMinHeap<Integer> heap = new MyMinHeap<>();
        heap.add(5);
        heap.add(3);
        heap.add(8);
        System.out.println("Heap poll: " + heap.poll());
    }
}