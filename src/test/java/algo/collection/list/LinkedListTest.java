package algo.collection.list;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {
    @Test
    public void testAddElementToLinkedList() {
        List<Integer> list = new LinkedList<>();
        assertEquals(0, list.size());
        int n = 5;
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        assertEquals(n, list.size());
    }

    @Test
    public void testGetElementByIndex() {
        List<Integer> list = new LinkedList<>();
        Integer[] data = {1, 2, 3 ,4, 5};
        for (Integer d : data) list.add(d);
        for (int i = 0; i < list.size(); i++) {
            assertEquals(data[i], list.get(i));
        }
    }

    @Test
    public void testRemoveElementByIndex() {
        List<Integer> list = new LinkedList<>();
        Integer[] data = {1, 2, 3, 4, 5};
        for (Integer d : data) list.add(d);
        list.remove(0);
        assertEquals(4, list.size());
        assertEquals(2, (int)list.get(0));

        list.remove(list.size()-1);
        assertEquals(3, list.size());
        assertEquals(4, (int)list.get(list.size()-1));

        list.remove(1);
        assertEquals(2, list.size());
        assertEquals(4, (int)list.get(1));

        list.remove(0);
        list.remove(0);
        assertEquals(0, list.size());

    }

    @Test
    public void testInsertElementToLinkedList() {
        List<Integer> list = new LinkedList<>();
        list.insert(0, 1);
        assertEquals(1, (int)list.get(0));
        assertEquals(1, list.size());

        list.insert(0, 2);
        assertEquals(2, (int)list.get(0));
        assertEquals(2, list.size());

        list.insert(1, 3);
        assertEquals(3, (int)list.get(1));
        assertEquals(3, list.size());
    }

    @Test
    public void testPutElementToList() {
        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= 5; i++) {
            list.add(i);
        }
        list.put(2, 5);
        assertEquals(5, (int)list.get(2));
        assertEquals(5, list.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPutElementIntoEmptyList() {
        List<Integer> list = new LinkedList<>();
        list.put(5, 5);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testPutElementIntoListOutOfBound() {
        List<Integer> list = new LinkedList<>();
        list.add(6);
        list.put(5, 5);
    }

    @Test
    public void testReverse() {
        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= 5; i++) {
            list.add(i);
        }
        List<Integer> reversed = list.reverse();
        for (int i = 0; i < list.size(); i++) {
            assertEquals(list.get(i), reversed.get(list.size() - i - 1));
        }
    }
}