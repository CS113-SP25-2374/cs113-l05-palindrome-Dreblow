import java.util.NoSuchElementException;


public class CircularArrayQueueTest {
    @Test
    void testAddAndOffer() {
        CircularArrayQueue<Integer> queue = new CircularArrayQueue<>();
        
        assertTrue(queue.offer(1));
        assertTrue(queue.offer(2));
        assertTrue(queue.offer(3));
        assertEquals(3, queue.size());
        assertEquals(1, queue.peek());
    }

    @Test
    void testPollAndRemove() {
        CircularArrayQueue<Integer> queue = new CircularArrayQueue<>();
        
        queue.add(10);
        queue.add(20);
        queue.add(30);
        
        assertEquals(10, queue.poll());
        assertEquals(20, queue.remove());
        assertEquals(30, queue.poll());
        assertNull(queue.poll());
        assertThrows(NoSuchElementException.class, queue::remove);
    }

    @Test
    void testPeekAndElement() {
        CircularArrayQueue<Integer> queue = new CircularArrayQueue<>();
        
        queue.add(5);
        assertEquals(5, queue.peek());
        assertEquals(5, queue.element());
        
        queue.poll();
        assertNull(queue.peek());
        assertThrows(NoSuchElementException.class, queue::element);
    }

    @Test
    void testResize() {
        CircularArrayQueue<Integer> queue = new CircularArrayQueue<>(3);
        
        queue.add(1);
        queue.add(2);
        queue.add(3);
        
        // Trigger resize
        queue.add(4);
        queue.add(5);
        
        assertEquals(5, queue.size());
        assertEquals(1, queue.poll());
        assertEquals(2, queue.poll());
    }

    @Test
    void testIsEmpty() {
        CircularArrayQueue<Integer> queue = new CircularArrayQueue<>();
        
        assertTrue(queue.isEmpty());
        queue.add(100);
        assertFalse(queue.isEmpty());
        queue.poll();
        assertTrue(queue.isEmpty());
    }
}
