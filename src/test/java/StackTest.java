import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class StackTest {

    @Test
    public void testSize() {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(7);

        assertEquals("[7, 5]",stack.toString());
    }

    @Test
    public void testIterator() {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(7);
        Iterator<Integer> iter = stack.iterator();

        assertNotNull(iter);
        assertTrue(iter.hasNext());
        assertEquals(new Integer(7), iter.next());
        assertTrue(iter.hasNext());
        assertEquals(new Integer(5), iter.next());
        assertFalse(iter.hasNext());
    }

    @Test
    public void testPop() {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(7);
        assertEquals(new Integer(7), stack.pop());
        assertEquals(new Integer(5), stack.pop());
    }
}
