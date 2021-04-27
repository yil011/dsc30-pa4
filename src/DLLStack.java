/*
 * NAME: Yifan Li
 * PID: A16669790
 */

/**
 * Class of stack using double linked list
 * @param <T> generic container
 * @author Yifan Li
 * @since 04/23/2021
 */
public class DLLStack<T> {

    private DoublyLinkedList<T> stack;
    /**
     * Constructor of stack
     */
    public DLLStack() {
        this.stack = new DoublyLinkedList<>();
    }
    /**
     * A method that returns the size of the stack
     */
    public int size() {
        return this.stack.size();
    }
    /**
     * A method that checks if the stack is empty
     *
     * @return true if empty, otherwise false
     */
    public boolean isEmpty() {
        return (this.stack.size() == 0);
    }
    /**
     * A method that pushes the given data.
     *
     * @param data the given element
     * @throws IllegalArgumentException if data is null
     */
    public void push(T data) {
        if (data == null) {
            throw new IllegalArgumentException();
        }
        this.stack.add(data);
    }
    /**
     * A method that pops the given data.
     * Return null of size is 0
     *
     * @return the element
     */
    public T pop() {
        if (this.size() == 0) {
            return null;
        }
        T result = this.stack.remove(this.size() - 1);
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
        T result = this.stack.get(this.size() - 1);
        return result;
    }

}
