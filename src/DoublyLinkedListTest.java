import org.junit.Before;
import org.junit.Test;
import java.util.AbstractList;
import static org.junit.Assert.*;

public class DoublyLinkedListTest {
    //global variables
    AbstractList<Integer> t;
    AbstractList<Boolean> t1;
    AbstractList<String> t2;

    @Before
    public void setUp() {

        t = new DoublyLinkedList();
        t1 = new DoublyLinkedList();
        t2 = new DoublyLinkedList();

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
        t.add(new Integer(3));
        assertEquals(new Integer(3), t.get(1));
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
    @Test(expected = NullPointerException.class)
    public void que2Test() {
        t.add(new Integer(1));
        t.set(0, null);
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void que3Test() {
        t.add(new Integer(1));
        t.set(2, new Integer(2));
    }

    @org.junit.Test
    public void t1Test() {
        t1.add(true);
        assertFalse(t1.isEmpty());
    }


    @Test
    public void swapSegment() {
        DoublyLinkedList<Integer> t4 =  new DoublyLinkedList<Integer>();
        DoublyLinkedList<Integer> t5 =  new DoublyLinkedList<Integer>();
        t4.add(new Integer(0));
        t4.add(new Integer(1));
        t4.add(new Integer(2));
        t4.add(new Integer(3));
        t4.add(new Integer(4));
        t5.add(new Integer(9));
        t5.add(new Integer(8));
        t5.add(new Integer(7));
        t5.add(new Integer(6));
        t5.add(new Integer(5));
        t4.swapSegment(t5, 2);
        String t4String = "[(head) -> 9 -> 8 -> 7 -> 3 -> 4 -> (tail)]";
        String t5String = "[(head) -> 0 -> 1 -> 2 -> 6 -> 5 -> (tail)]";
        System.out.println(t4.toString());
        System.out.println(t5.toString());
        assertEquals(new Integer(9), t4.get(0));
        assertEquals(new Integer(0), t5.get(0));
        t4.clear();;
        t5.clear();
        t4.add(new Integer(0));
        t4.add(new Integer(1));
        t4.add(new Integer(2));
        t4.add(new Integer(3));
        t4.add(new Integer(4));
        t5.add(new Integer(9));
        t5.add(new Integer(8));
        t5.add(new Integer(7));
        t5.add(new Integer(6));
        t5.add(new Integer(5));
        t4.swapSegment(t5, 1);
        assertEquals(new Integer(8), t4.get(1));
        assertEquals(new Integer(1), t5.get(1));
        t4.swapSegment(t5,3);
        assertEquals(new Integer(1), t4.get(1));
        assertEquals(new Integer(8), t5.get(1));

    }

    @Test
    public void removeMultipleOf() {
        DoublyLinkedList<Integer> t3 =  new DoublyLinkedList<Integer>();
        for (int i = 0; i < 10; i++) {
            t3.add(new Integer(i));
        }
        assertEquals(10, t3.size());
        t3.removeMultipleOf(3);
        assertEquals(6, t3.size());
        assertEquals(new Integer(1), t3.get(0));
        t3.clear();
        for (int i = 0; i < 10; i++) {
            t3.add(new Integer(i));
        }
        t3.removeMultipleOf(4);
        assertEquals(7, t3.size());
        assertEquals(new Integer(3), t3.get(2));
        t3.clear();
        for (int i = 0; i < 11; i++) {
            t3.add(new Integer(i));
        }
        t3.removeMultipleOf(5);
        assertEquals(8, t3.size());
    }

}
