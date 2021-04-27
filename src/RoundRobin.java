/*
 * NAME: Yifan Li
 * PID: A16669790
 */

/**
 * class of RoundRobin
 * @author Yifan Li
 * @since 04/23/2021
 */
public class RoundRobin {

    /* constants */
    private static final String TASK_HANDLED = "All tasks are already handled.";

    /* instance variables */
    private DoublyLinkedList<Task> waitlist, finished;
    private int quantum, burstTime, waitTime;

    public RoundRobin(Task[] toHandle) {
        new RoundRobin(4, toHandle);
    }

    public RoundRobin(int quantum, Task[] toHandle) {
        if (quantum < 1 ||toHandle == null) {
            throw new IllegalArgumentException();
        }
        this.waitlist = new DoublyLinkedList<Task>();
        for (Task task: toHandle) {
            this.waitlist.add(task);
        }
        this.finished = new DoublyLinkedList<Task>();
        this.quantum = quantum;


    }

    public String handleAllTasks() {
        if(this.waitlist.isEmpty()) {
            return TASK_HANDLED;
        }
        for (Task task: this.waitlist) {
            for(int i = 0; i < this.quantum; i++) {
                if(task.handleTask()) {
                    
                }
            }
        }

    }

    /**
     * Main method for testing.
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Task[] test1 = {new Task("A", 3), new Task("B", 4),
                        new Task("C", 4), new Task("D", 12),
                        new Task("E", 6), new Task("F", 3)};
        RoundRobin rr1 = new RoundRobin(3, test1);     // Quantum: 3, ToHandle: test1
        System.out.println(rr1.handleAllTasks());   // Burst: 32, Wait: 86, Order: AFBCED
        System.out.println();
        System.out.println(rr1.handleAllTasks());   // TASK_HANDLED
        System.out.println();

        Task[] test2 = {new Task("A", 9), new Task("B", 8),
                        new Task("C", 6), new Task("D", 4),
                        new Task("E", 4), new Task("F", 3)};
        RoundRobin rr2 = new RoundRobin(test2);  // Quantum: 4, ToHandle: test2
        System.out.println(rr2.handleAllTasks());   // Burst: 34, Wait: 123, Order: DEFBCA
        System.out.println();
        System.out.println(rr2.handleAllTasks());   // TASK_HANDLED
        System.out.println();

        Task[] test3 = {new Task("A", 7), new Task("B", 5),
                        new Task("C", 3), new Task("D", 1),
                        new Task("E", 2), new Task("F", 4),
                        new Task("G", 6), new Task("H", 8)};
        RoundRobin rr3 = new RoundRobin(3, test3);     // Quantum: 3, ToHandle: test3
        System.out.println(rr3.handleAllTasks());   // Burst: 36, Wait: 148, Order: CDEBFGAH
        System.out.println();
        System.out.println(rr3.handleAllTasks());   // TASK_HANDLED
        System.out.println();
    }
}
