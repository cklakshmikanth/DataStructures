import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QueueTest {

    @Test
    public void testToString() {
        Queue<Integer> queue = new Queue<>(3);
        queue.enqueue(3);
        queue.enqueue(1);
        queue.enqueue(7);

        assertEquals("[ 3 1 7 ]", queue.toString());

        assertEquals(new Integer(3), queue.dequeue());
        queue.enqueue(4);

        assertEquals("[ 1 7 4 ]", queue.toString());
        assertEquals(new Integer(1), queue.peek());

    }
}
