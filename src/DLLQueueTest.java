import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DLLQueueTest {
    DLLQueue<Integer> q;
    DLLQueue<String> q1;
    DLLQueue<Boolean> q2;
    @Before
    public void setUp() {
        q = new DLLQueue<>();
        q1 = new DLLQueue<>();
        q2 = new DLLQueue<>();
    }

    @Test
    public void size() {
    }
    @Test
    public void QueueTest() {
        assertTrue(q.isEmpty());
        q.enqueue(new Integer(5));
        //System.out.println(q.size());
        assertEquals(1, q.size());
        assertEquals(new Integer(5), q.peek());
        q.enqueue(new Integer(1));
        assertEquals(new Integer(5), q.dequeue());
        //System.out.println(q.size());
        assertEquals(new Integer(1), q.dequeue());
        assertTrue(q.isEmpty());
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
    @Test(expected = IllegalArgumentException.class)
    public void queTest() {
        q.enqueue(null);
    }
    @Test
    public void s1Test() {
        assertTrue(q1.isEmpty());
        q1.enqueue("Hi");
        assertFalse(q1.isEmpty());
        assertEquals("Hi", q1.dequeue());
    }
    @Test
    public void s2Test() {
        assertTrue(q2.isEmpty());
        q2.enqueue(true);
        assertFalse(q2.isEmpty());
        assertEquals(true, q2.dequeue());
    }
}
