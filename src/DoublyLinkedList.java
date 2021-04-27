/*
 * NAME: Yifan Li
 * PID: A16669790
 */

import java.util.AbstractList;
import java.util.ArrayList;

/**
 * class of DoublyLinkedList
 * @author Yifan Li
 * @since 04/23/2021
 */
public class DoublyLinkedList<T> extends AbstractList<T> {

    /* DLL instance variables */
    private int nelems;
    private Node head;
    private Node tail;

    /**
     * Node for chaining together to create a linked list
     */
    protected class Node {

        /* Node instance variables */
        T data;
        Node next;
        Node prev;

        /**
         * Constructor to create singleton Node
         */
        private Node(T element) {
            this.data = element;
        }

        /**
         * Constructor to create singleton link it between previous and next
         *
         * @param element  Element to add, can be null
         * @param nextNode successor Node, can be null
         * @param prevNode predecessor Node, can be null
         */
        private Node(T element, Node nextNode, Node prevNode) {
            this.data = element;
            this.next = nextNode;
            this.prev = prevNode;
        }

        /**
         * Set the element
         *
         * @param element new element
         */
        public void setElement(T element) {
            this.data = element;
        }

        /**
         * Accessor to get the Nodes Element
         */
        public T getElement() {
            return this.data;
        }

        /**
         * Set the next node in the list
         *
         * @param n new next node
         */
        public void setNext(Node n) {
            this.next = n;
        }

        /**
         * Get the next node in the list
         *
         * @return the successor node
         */
        public Node getNext() {
            return this.next;
        }

        /**
         * Set the previous node in the list
         *
         * @param p new previous node
         */
        public void setPrev(Node p) {
            this.prev = p;
        }


        /**
         * Accessor to get the prev Node in the list
         *
         * @return predecessor node
         */
        public Node getPrev() {
            return this.prev;
        }

        /**
         * Remove this node from the list.
         * Update previous and next nodes
         */
        public void remove() {
            this.prev.next = this.next;
        }
    }

    /**
     * Creates a new, empty doubly-linked list.
     */
    public DoublyLinkedList() {
        //DoublyLinkedList dList = new DoublyLinkedList();
        this.head = new Node(null);
        this.tail = new Node(null);
        this.nelems = 0;
    }

    /**
     * Add an element to the end of the list
     *
     * @param element data to be added
     * @return whether or not the element was added
     * @throws NullPointerException if data received is null
     */
    @Override
    public boolean add(T element) throws NullPointerException {
        if (element == null) {
            throw new NullPointerException();
        }
        if (this.nelems == 0) {
            /*
            Node temp = new Node(element);
            this.head.setNext(temp);
            temp.setNext(this.tail);
            this.tail.setPrev(temp);
            this.tail.setNext(null);
            nelems++;
             */
            Node temp = new Node(element, this.tail, this.head);
            this.head.setNext(temp);
            this.tail.setPrev(temp);
            this.nelems++;
            // implementation of adding the new data
            return true;
        } else {

            Node temp = new Node(element, this.tail, this.tail.getPrev());
            this.tail.getPrev().setNext(temp);
            this.tail.setPrev(temp);
            this.nelems++;
            return true;
        }
    }


    /**
     * Adds an element to a certain index in the list, shifting exist elements
     * create room. Does not accept null values.
     *
     * @param element data to be added
     * @return whether or not the element was added
     * @throws IndexOutOfBoundsException if index is out of range
     * @throws NullPointerException if data received is null
     */
    @Override
    public void add(int index, T element)
            throws IndexOutOfBoundsException, NullPointerException {
        if (index < 0 || index > this.nelems) {
            throw new IndexOutOfBoundsException();
        }
        if (element == null) {
            throw new NullPointerException();
        }
        // implementation of adding the new data
        if (this.nelems == 0 && index == 0) {
            Node temp = new Node(element, this.tail, this.head);
            this.head.setNext(temp);
            this.tail.setPrev(temp);
            this.nelems++;
        } else {
            Node temp = new Node(element);
            //Node nodeCur = this.head;
            Node nodeCur = new Node(this.head.getElement(),
                    this.head.getNext(), null);
            for (int i = 0; i < index; i++) {
                nodeCur  = nodeCur .getNext();
            }
            // nodeCur points to the node before the insert point
            temp.setNext(nodeCur.getNext());
            nodeCur.setNext(temp);
            temp.setPrev(nodeCur);
            temp.getNext().setPrev(temp);
            this.nelems++;
        }

    }

    /**
     * Clear the linked list
     */
    @Override
    public void clear() {
        this.head.setNext(this.tail);
        this.tail.setPrev(this.head);
        this.nelems = 0;
    }

    /**
     * Determine if the list contains the data element anywhere in the list.
     *
     * @param element data to be tested
     * @return true/false, whether or not the element was contained
     */
    @Override
    public boolean contains(Object element) {
        T data = (T) element;
        //Node nodeCur = this.head;
        Node nodeCur = new Node(this.head.getElement(), this.head.getNext(), null);
        for (int i = 0; i < this.nelems; i++) {
            nodeCur  = nodeCur.getNext();
            if (element.equals(nodeCur.getElement())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Retrieves the element stored with a given index on the list.
     * @param index index of the data
     * @return whether or not the element was added
     * @throws IndexOutOfBoundsException if index is out of range
     */
    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > this.nelems) {
            throw new IndexOutOfBoundsException();
        }
        T result = getNth(index).getElement();
        // nodeCur points to the node before the insert point
        return result;
    }

    /**
     * Helper method to get the Nth node in our list
     *
     * @param index the given index
     * @return node at given index will be returned
     */
    private Node getNth(int index) {
        //Node nodeCur = this.head;
        Node nodeCur = new Node(this.head.getElement(),
                this.head.getNext(), null);
        for (int i = 0; i < index + 1; i++) {
            nodeCur  = nodeCur.getNext();
        }
        // nodeCur points to the node before the insert point
        return nodeCur;
    }

    /**
     * Determine if the list empty
     *
     * @return boolean true if the list is empty
     */
    @Override
    public boolean isEmpty() {
        return this.nelems == 0;
    }

    /**
     * Remove the element from position index in the list
     *
     * @param index the given index to remove
     * @return T element is returned
     * @throws IndexOutOfBoundsException if index < 0 or index is
     * greater than the size
     */
    @Override
    public T remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > this.nelems) {
            throw new IndexOutOfBoundsException();
        }
        // set current node
        Node nodeCur = new Node(this.head.getElement(),
                this.head.getNext(), null);
        for (int i = 0; i < index + 1; i++) {
            nodeCur  = nodeCur.getNext();
        }
        // nodeCur points to the node before the insert point
        T content = nodeCur.getElement();
        nodeCur.remove();
        //reduce the size
        this.nelems--;
        return content;
    }

    /**
     * Set the value of an element at a certain index in the list.
     *
     * @param index the given index
     * @param element the given element to replace with
     * @return T element is returned
     * @throws IndexOutOfBoundsException if index is out of range
     * @throws NullPointerException if data received is null
     */
    @Override
    public T set(int index, T element)
            throws IndexOutOfBoundsException, NullPointerException {
        // check for exceptions
        if (index < 0 || index > this.nelems) {
            throw new IndexOutOfBoundsException();
        }
        if (element == null) {
            throw new NullPointerException();
        }
        // create temporary node
        Node temp = new Node(element);
        Node nodeCur = this.head;
        for (int i = 0; i < index + 1; i++) {
            nodeCur  = nodeCur.getNext();
        }
        // nodeCur points to the node before the insert point
        T oldN = nodeCur.getElement();
        nodeCur.setElement(element);
        return oldN;
    }

    /**
     * Retrieves the amount of elements that are currently on the list.
     *
     * @return int the size of the list
     */
    @Override
    public int size() {
        return this.nelems;
    }

    /**
     * String representation of this list in the form of:
     * "[(head) -> elem1 -> elem2 -> ... -> elemN -> (tail)]"
     *
     * @return String that contains the elements
     */
    @Override
    public String toString() {
        ArrayList<String> temp = new ArrayList<>();
        if (this.nelems == 0) {
            temp.add("(head) -> (tail)");
            return temp.toString();
        } else {
            String result = "";
            Node nodeCur = this.head;
            temp.add("[(head) -> ");
            for (int i = 0; i < this.nelems; i++) {
                nodeCur = nodeCur.getNext();
                String nodeData =
                        nodeCur.getElement().toString();
                temp.add(nodeData + " -> ");
            }
            temp.add("(tail)]");
            for (String ele: temp) {
                result += ele;
            }
            return result;
        }
    }

    /* ==================== EXTRA CREDIT ==================== */

    /**
     * Remove nodes whose index is a multiple of base
     *
     * TODO: javadoc comments
     */
    public void removeMultipleOf(int base) {
        // TODO: complete implementation       
    }

    /**
     * Swap the nodes between index [0, splitIndex] of two lists
     *
     * TODO: javadoc comments
     */
    public void swapSegment(DoublyLinkedList other, int splitIndex) {
        // TODO: complete implementation
    }
    public void main (String[] args) {
        DoublyLinkedList t = new DoublyLinkedList();
        System.out.println(t.size());
    }

}
