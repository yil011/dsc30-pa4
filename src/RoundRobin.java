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
    /**
     * Constructor of RoundRobin
     */
    public RoundRobin(Task[] toHandle) {
        // call another constructor
        this(4, toHandle);
    }
    /**
     * Constructor of RoundRobin
     * @param quantum the size of quantum
     * @param toHandle the task list
     * @throws IllegalArgumentException if quantum is less than
     * 1, toHandle is null or no element in toHandle list
     */
    public RoundRobin(int quantum, Task[] toHandle) {
        // check for exceptions
        if (quantum < 1 || toHandle == null || toHandle.length == 0) {
            throw new IllegalArgumentException();
        }
        // initialize the waitlist
        this.waitlist = new DoublyLinkedList<Task>();
        for (Task task: toHandle) {
            this.waitlist.add(task);
        }
        // initialize the finished list
        this.finished = new DoublyLinkedList<Task>();
        this.quantum = quantum;
    }
    /**
     * A method that handles all tasks
     * @return String return a string with burst time,
     * wait time and the list of task information
     */
    public String handleAllTasks() {
        // return String if no elements in waitlist
        if (this.waitlist.isEmpty()) {
            return TASK_HANDLED;
        }
        // set counters for the loop below
        int waitCount = 0;
        int currSize;
        // create temporary list to store unfinished tasks
        DoublyLinkedList<Task> temp = new DoublyLinkedList<Task>();
        while (this.waitlist.size() != 0) {
            // reassign value of size
            currSize = this.waitlist.size();
            for (int a = 0; a < this.waitlist.size(); a++) {
                // assign curT
                Task curT =  this.waitlist.get(a);
                for (int i = 0; i < this.quantum; i++) {
                    // check if curT is finished
                    if (!curT.isFinished()) {
                        curT.handleTask();
                        // add to time counters
                        this.burstTime++;
                        waitCount++;
                    }
                }
                currSize--;
                // calculate the waittime for this round
                this.waitTime += (currSize
                        + temp.size()) * waitCount;
                //reset waitCount
                waitCount = 0;
                if (curT.isFinished()) {
                    this.finished.add(curT);
                } else {
                    temp.add(curT);
                }
            }
            // clear waitList and assign it with tasks stored
            //in the temp list
            this.waitlist.clear();
            for (Task ele: temp) {
                this.waitlist.add(ele);
            }
            // clear temp for reuse purpose in next round
            temp.clear();
        }
        // format the return string
        String strEnd = "";
        // collect all tasks' information
        for (int i = 0; i < this.finished.size(); i++) {
            if (i != this.finished.size() - 1) {
                strEnd += this.finished.get(i).toString();
                strEnd +=  " -> ";
            } else {
                strEnd += this.finished.get(i).toString();
            }
        }
        // format the burstTime and waitTime
        String burst = String.valueOf(this.burstTime);
        String wait = String.valueOf(this.waitTime);
        String strFront = "All tasks are handled within " + burst
                + " units of burst time and " + wait + " units of wait time. "
                + "The tasks are finished in this order:\n";
        return strFront + strEnd;
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
