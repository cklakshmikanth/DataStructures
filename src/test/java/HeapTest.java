import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class HeapTest {

    @Test
    public void testHeapUsingArrayList() {
        HeapUsingArrayList<Integer> pq = new HeapUsingArrayList<>();
        pq.add(19);
        pq.add(14);
        pq.add(5);
        pq.add(7);
        pq.add(11);
        pq.add(6);
        pq.add(12);
        pq.add(8);
        pq.add(13);
        pq.add(12);

        //assertTrue(pq.isMinHeap(0));

        assertEquals(new Integer(5), pq.poll());
        assertEquals(new Integer(6), pq.poll());
        assertEquals(new Integer(7), pq.poll());
        assertEquals(new Integer(8), pq.poll());
        assertEquals(new Integer(11), pq.poll());
        assertEquals(new Integer(12), pq.poll());
        assertEquals(new Integer(12), pq.poll());
        assertEquals(new Integer(13), pq.poll());
        assertEquals(new Integer(14), pq.poll());
        assertEquals(new Integer(19), pq.poll());
    }

    @Test
    public void testHeapUsingArray() {
        HeapUsingArray<Integer> pq = new HeapUsingArray<>(10);
        pq.add(19);
        pq.add(14);
        pq.add(5);
        pq.add(7);
        pq.add(11);
        pq.add(6);
        pq.add(12);
        pq.add(8);
        pq.add(13);
        pq.add(12);

        //assertTrue(pq.isMinHeap(0));

        assertEquals(new Integer(5), pq.poll());
        assertEquals(new Integer(6), pq.poll());
        assertEquals(new Integer(7), pq.poll());
        assertEquals(new Integer(8), pq.poll());
        assertEquals(new Integer(11), pq.poll());
        assertEquals(new Integer(12), pq.poll());
        assertEquals(new Integer(12), pq.poll());
        assertEquals(new Integer(13), pq.poll());
        assertEquals(new Integer(14), pq.poll());
        assertEquals(new Integer(19), pq.poll());
    }

    @Test
    public void testHeapify() {
        HeapUsingArray<Integer> heap = new HeapUsingArray<>();
        Integer[] integers = new Integer[] { 15, 5, 20, 1, 17, 10, 30};
        heap.heapify(integers);

        assertEquals("[30, 17, 20, 1, 5, 10, 15]", Arrays.toString(integers));
    }
}
