/*
 * NAME: Yifan Li
 * PID: A16669790
 */

/**
 * Class of queque using double linked list
 * @param <T> generic container
 * @author Yifan Li
 * @since 04/23/2021
 */
public class DLLQueue<T> {

    private DoublyLinkedList<T> queue;
    /**
     * Constructor of stack
     */
    public DLLQueue() {
        this.queue = new DoublyLinkedList<>();
    }
    /**
     * A method that returns the size of the queue
     */
    public int size() {
        return this.queue.size();
    }
    /**
     * A method that checks if the stack is empty
     *
     * @return true if empty, otherwise false
     */
    public boolean isEmpty() {
        return (this.queue.size() == 0);
    }
    /**
     * A method that enqueues the given data.
     *
     * @param data the given element
     * @throws IllegalArgumentException if data is null
     */
    public void enqueue(T data) {
        if (data == null) {
            throw new IllegalArgumentException();
        }
        this.queue.add(data);
    }
    /**
     * A method that pops the given data.
     * Return null of size is 0
     *
     * @return the element
     */
    public T dequeue() {
        if (this.size() == 0) {
            return null;
        }
        T result = this.queue.remove(0);
        return result;
    }
    /**
     * A method that pops the given data.
     * Return null of size is 0
     *
     * @return the element
     */
    public T peek() {
        if (this.size() == 0) {
            return null;
        }
        T result = this.queue.get(0);
        return result;
    }

}
