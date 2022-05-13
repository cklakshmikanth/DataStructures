import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {

    @Test
    public void testAdd() {
        BinarySearchTreeUsingIteration<Integer> bst = new BinarySearchTreeUsingIteration<>();

        bst.add(10);
        assertEquals("[ 10 ]", bst.getInOrder());

        bst.add(6);
        assertEquals("[ 6 10 ]", bst.getInOrder());

        bst.add(15);
        assertEquals("[ 6 10 15 ]", bst.getInOrder());

        bst.add(4);
        assertEquals("[ 4 6 10 15 ]", bst.getInOrder());

        bst.add(5);
        assertEquals("[ 4 5 6 10 15 ]", bst.getInOrder());

        bst.add(13);
        assertEquals("[ 4 5 6 10 13 15 ]", bst.getInOrder());

        bst.add(18);
        assertEquals("[ 4 5 6 10 13 15 18 ]", bst.getInOrder());

        bst.add(16);
        assertEquals("[ 4 5 6 10 13 15 16 18 ]", bst.getInOrder());
    }

    @Test
    public void testRemoveLeafNodes() {
        BinarySearchTreeUsingIteration<Integer> bst = new BinarySearchTreeUsingIteration<>();
        bst.add(10);
        bst.add(15);

        assertEquals("[ 10 15 ]", bst.getInOrder());

        bst.remove(15);
        assertEquals("[ 10 ]", bst.getInOrder());

        bst.add(6);
        assertEquals("[ 6 10 ]", bst.getInOrder());

        bst.remove(6);
        assertEquals("[ 10 ]", bst.getInOrder());

        bst.remove(10);
        assertEquals("[ ]", bst.getInOrder());
    }

    @Test
    public void testRemoveNodeWhichHasLeftSubtree() {
        BinarySearchTreeUsingIteration<Integer> bst = new BinarySearchTreeUsingIteration<>();
        bst.add(10);
        bst.add(15);
        bst.add(13);

        assertEquals("[ 10 13 15 ]", bst.getInOrder());

        bst.remove(15);
        assertEquals("[ 10 13 ]", bst.getInOrder());

        bst.remove(13);
        assertEquals("[ 10 ]", bst.getInOrder());

        bst.remove(10);
        assertEquals("[ ]", bst.getInOrder());
    }

    @Test
    public void testRemoveNodeWhichHasRightSubtree() {
        BinarySearchTreeUsingIteration<Integer> bst = new BinarySearchTreeUsingIteration<>();
        bst.add(10);
        bst.add(5);
        bst.add(7);

        assertEquals("[ 5 7 10 ]", bst.getInOrder());

        bst.remove(5);
        assertEquals("[ 7 10 ]", bst.getInOrder());

        bst.remove(7);
        assertEquals("[ 10 ]", bst.getInOrder());

        bst.remove(10);
        assertEquals("[ ]", bst.getInOrder());
    }

    @Test
    public void testRemoveNodeWhichHasBothSubtrees() {
        BinarySearchTreeUsingIteration<Integer> bst = new BinarySearchTreeUsingIteration<>();
        bst.add(10);
        bst.add(15);
        bst.add(13);
        bst.add(18);
        bst.add(14);
        bst.add(16);

        assertEquals("[ 10 13 14 15 16 18 ]", bst.getInOrder());

        bst.remove(15);
        assertEquals("[ 10 13 14 16 18 ]", bst.getInOrder());

        bst.remove(13);
        assertEquals("[ 10 14 16 18 ]", bst.getInOrder());

        bst.remove(16);
        assertEquals("[ 10 14 18 ]", bst.getInOrder());
    }

    @Test
    public void testAdd1() {
        BinarySearchTreeUsingRecursion<Integer> bst = new BinarySearchTreeUsingRecursion<>();

        bst.add(10);
        assertEquals("[ 10 ]", bst.getInOrder());

        bst.add(6);
        assertEquals("[ 6 10 ]", bst.getInOrder());

        bst.add(15);
        assertEquals("[ 6 10 15 ]", bst.getInOrder());

        bst.add(4);
        assertEquals("[ 4 6 10 15 ]", bst.getInOrder());

        bst.add(5);
        assertEquals("[ 4 5 6 10 15 ]", bst.getInOrder());

        bst.add(13);
        assertEquals("[ 4 5 6 10 13 15 ]", bst.getInOrder());

        bst.add(18);
        assertEquals("[ 4 5 6 10 13 15 18 ]", bst.getInOrder());

        bst.add(16);
        assertEquals("[ 4 5 6 10 13 15 16 18 ]", bst.getInOrder());
    }

    @Test
    public void testRemoveLeafNodes1() {
        BinarySearchTreeUsingRecursion<Integer> bst = new BinarySearchTreeUsingRecursion<>();
        bst.add(10);
        bst.add(15);

        assertEquals("[ 10 15 ]", bst.getInOrder());

        bst.remove(15);
        assertEquals("[ 10 ]", bst.getInOrder());

        bst.add(6);
        assertEquals("[ 6 10 ]", bst.getInOrder());

        bst.remove(6);
        assertEquals("[ 10 ]", bst.getInOrder());

        bst.remove(10);
        assertEquals("[ ]", bst.getInOrder());
    }

    @Test
    public void testRemoveNodeWhichHasLeftSubtree1() {
        BinarySearchTreeUsingRecursion<Integer> bst = new BinarySearchTreeUsingRecursion<>();
        bst.add(10);
        bst.add(15);
        bst.add(13);

        assertEquals("[ 10 13 15 ]", bst.getInOrder());

        bst.remove(15);
        assertEquals("[ 10 13 ]", bst.getInOrder());

        bst.remove(13);
        assertEquals("[ 10 ]", bst.getInOrder());

        bst.remove(10);
        assertEquals("[ ]", bst.getInOrder());
    }

    @Test
    public void testRemoveNodeWhichHasRightSubtree1() {
        BinarySearchTreeUsingRecursion<Integer> bst = new BinarySearchTreeUsingRecursion<>();
        bst.add(10);
        bst.add(5);
        bst.add(7);

        assertEquals("[ 5 7 10 ]", bst.getInOrder());

        bst.remove(5);
        assertEquals("[ 7 10 ]", bst.getInOrder());

        bst.remove(7);
        assertEquals("[ 10 ]", bst.getInOrder());

        bst.remove(10);
        assertEquals("[ ]", bst.getInOrder());
    }

    @Test
    public void testRemoveNodeWhichHasBothSubtrees1() {
        BinarySearchTreeUsingRecursion<Integer> bst = new BinarySearchTreeUsingRecursion<>();
        bst.add(10);
        bst.add(15);
        bst.add(13);
        bst.add(18);
        bst.add(14);
        bst.add(16);

        assertEquals("[ 10 13 14 15 16 18 ]", bst.getInOrder());

        bst.remove(15);
        assertEquals("[ 10 13 14 16 18 ]", bst.getInOrder());

        bst.remove(13);
        assertEquals("[ 10 14 16 18 ]", bst.getInOrder());

        bst.remove(16);
        assertEquals("[ 10 14 18 ]", bst.getInOrder());
    }

}