import org.junit.Before;
import org.junit.Test;

import java.util.AbstractList;

import static org.junit.Assert.*;

public class DLLStackTest {
    DLLStack<Integer> s;
    DLLStack<String> s1;
    DLLStack<Boolean> s2;
    @Before
    public void setUp() {
        s = new DLLStack<>();
        s1 = new DLLStack<>();
        s2 = new DLLStack<>();
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
        s.push(new Integer(2));
        s.push(new Integer(4));
        assertEquals(new Integer(4), s.pop());
        System.out.println(s.size());
        assertFalse(s.isEmpty());
        //s.push(new Integer(9));
        assertEquals(new Integer(2), s.pop());
        System.out.println(s.size());
        assertEquals(new Integer(1), s.pop());
        s.pop();
        assertTrue(s.isEmpty());
        //s.peek();
        //System.out.println(s.size());
        //assertEquals(2,s.size());
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
    public void stack1Test() {
        s.push(null);
    }
    @Test
    public void s1Test() {
        assertTrue(s1.isEmpty());
        s1.push("Hi");
        assertFalse(s1.isEmpty());
        assertEquals("Hi", s1.pop());
    }
    @Test
    public void s2Test() {
        assertTrue(s2.isEmpty());
        s2.push(true);
        assertFalse(s2.isEmpty());
        assertEquals(true, s2.pop());
    }
}
