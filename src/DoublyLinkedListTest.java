import org.junit.Before;
import org.junit.Test;
import java.util.AbstractList;
import static org.junit.Assert.*;

public class DoublyLinkedListTest {
    //global variables
    AbstractList<Integer> t;
    DLLQueue<Integer> q;
    DLLStack<Integer> s;
    @Before
    public void setUp() {

        t = new DoublyLinkedList();
        q = new DLLQueue<>();
        s = new DLLStack<>();

    }
    @org.junit.Test
    public void addTest() {
        assertEquals(0,t.size());
        //System.out.println(t.toString());
        assertTrue(t.isEmpty());
        String s1 = "[(head) -> (tail)]";
        assertEquals(s1,t.toString());
        t.add(0,new Integer(1));
        t.set(0,new Integer(5));
        assertEquals(new Integer(5), t.get(0));
        t.remove(0);
        assertEquals(0,t.size());
        t.add(new Integer(1));
        assertEquals(1,t.size());
        String s2 = "[(head) -> 1 -> (tail)]";
        assertEquals(s2,t.toString());
        t.add(new Integer(5));
        t.add(1,6);
        assertEquals(3,t.size());
        assertFalse(t.isEmpty());
        //System.out.println(t.toString());
        assertTrue(t.contains(new Integer(1)));
        assertEquals(new Integer(1), t.get(0));
        assertEquals(new Integer(6), t.get(1));
        assertEquals(new Integer(5), t.get(2));
        t.set(0,new Integer(9));
        assertEquals(new Integer(9), t.get(0));
        assertTrue(t.contains(new Integer(5)));
        assertFalse(t.contains(new Integer(2)));
        String s3 = "[(head) -> 9 -> 6 -> 5 -> (tail)]";
        assertEquals(s3,t.toString());
        t.remove(1);
        assertEquals(new Integer(5), t.get(1));
        t.remove(1);
        assertEquals(1,t.size());
        assertEquals(new Integer(9), t.get(0));
        t.clear();
        assertEquals(0,t.size());
        assertTrue(t.isEmpty());
        t.add(new Integer(1));
        assertEquals(1,t.size());



        //assertEquals(1,t.size());


    }
    @Test(expected = NullPointerException.class)
    public void add1Test() {
        DoublyLinkedList t = new DoublyLinkedList();
        t.add(null);
    }
    @Test(expected =  IndexOutOfBoundsException.class)
    public void add2Test() {
        t.add(1,new Integer(1));
    }
    @Test(expected =  NullPointerException.class)
    public void add3Test() {
        DoublyLinkedList t = new DoublyLinkedList();
        t.add(0,null);
    }
    @Test(expected =  IndexOutOfBoundsException.class)
    public void getTest() {
        t.get(5);
    }
    @Test(expected =  IndexOutOfBoundsException.class)
    public void removeTest() {
        t.remove(5);
    }
    @Test(expected =  IndexOutOfBoundsException.class)
    public void setTest() {
        t.set(-1,new Integer(2));
    }
    @Test(expected =  NullPointerException.class)
    public void set1Test() {
        t.set(0,null);
    }

    @Test
    public void DLLQueueTest() {
        assertTrue(q.isEmpty());
        q.enqueue(new Integer(5));
        //System.out.println(q.size());
        assertEquals(1, q.size());
        assertEquals(new Integer(5), q.peek());
        q.enqueue(new Integer(1));
        assertEquals(new Integer(5), q.dequeue());
        //System.out.println(q.size());
        assertEquals(new Integer(1), q.dequeue());
        //assertFalse(q.isEmpty());
        q.enqueue(new Integer(4));
        System.out.println(q.size());
        //assertEquals(new Integer(4), q.dequeue());
        System.out.println(q.size());
        q.enqueue(new Integer(9));
        System.out.println(q.size());
        assertEquals(new Integer(4), q.dequeue());
        assertEquals(new Integer(9), q.peek());
        //assertEquals(new Integer(2), q.dequeue());
    }
    @Test
    public void stackTest() {
        assertTrue(s.isEmpty());
        s.push(new Integer(5));
        //System.out.println(q.size());
        assertEquals(1, s.size());
        assertEquals(new Integer(5), s.peek());
        System.out.println(s.size());
        s.push(new Integer(1));
        assertEquals(new Integer(1), s.pop());
        System.out.println(s.size());
        assertTrue(q.isEmpty());
        s.push(new Integer(4));
        assertFalse(s.isEmpty());
        s.push(new Integer(9));
        System.out.println(s.size());
        assertEquals(3,s.size());
        //assertEquals(new Integer(9), s.pop());
        //assertEquals(new Integer(4), s.peek());
        //System.out.println(q.size());
        /*
        assertFalse(q.isEmpty());
        q.enqueue(new Integer(4));
        System.out.println(q.size());
        //assertEquals(new Integer(4), q.dequeue());
        System.out.println(q.size());
        q.enqueue(new Integer(9));
        System.out.println(q.size());
        assertEquals(new Integer(4), q.dequeue());
        assertEquals(new Integer(9), q.peek());

         */
    }
    @Test(expected = IllegalArgumentException.class)
    public void queTest() {
        q.enqueue(null);
    }
    @Test(expected = IllegalArgumentException.class)
    public void stack1Test() {
        s.push(null);
    }
    @org.junit.Test
    public void testAdd() {
    }

    @org.junit.Test
    public void clear() {
    }

    @Test
    public void contains() {
    }
}
