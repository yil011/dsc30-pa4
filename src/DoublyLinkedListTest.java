import org.junit.Before;
import org.junit.Test;
import java.util.AbstractList;
import static org.junit.Assert.*;

public class DoublyLinkedListTest {
    //global variables
    AbstractList<Integer > t;
    @Before
    public void setUp() {

        t = new DoublyLinkedList();

    }
    @org.junit.Test
    public void addTest() {
        assertEquals(0,t.size());
        t.add(0,new Integer(1));
        assertEquals(1,t.size());
        t.add(new Integer(5));
        assertEquals(2,t.size());
        assertEquals(new Integer(1), t.get(0) );

        //assertEquals(1,t.size());


    }
    @Test(expected = NullPointerException.class)
    public void add1Test() {
        DoublyLinkedList t = new DoublyLinkedList();
        t.add(null);
    }
    @Test(expected =  IndexOutOfBoundsException.class)
    public void add2Test() {
        DoublyLinkedList t = new DoublyLinkedList();
        t.add(1,new Integer(1));
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
