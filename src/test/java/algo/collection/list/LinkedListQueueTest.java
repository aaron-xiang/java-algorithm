package algo.collection.list;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListQueueTest {
    private Queue<Integer> queue;

    @Before
    public void setup() {
        queue = new LinkedListQueue<>();
    }

    @Test
    public void testEnqueueDequeue() {
        for (int i = 1; i <= 5; i++) {
            queue.enqueue(i);
        }
        int size = 5;
        assertEquals(size, queue.size());
        for (int i = 1; i <= 5; i++) {
            assertEquals(Integer.valueOf(i), queue.dequeue());
            assertEquals(--size, queue.size());
        }
    }

    @Test
    public void peek() {
        for (int i = 1; i <= 5; i++) {
            queue.enqueue(i);
        }
        int size = 5;
        for (int i = 1; i <= 5; i++) {
            Integer v = queue.peek();
            assertEquals(Integer.valueOf(i), v);
            assertEquals(size, queue.size());
            queue.dequeue();
            size--;
        }
    }

}