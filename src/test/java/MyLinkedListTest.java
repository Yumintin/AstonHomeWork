import org.example.CustomList.MyLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {
    private MyLinkedList<String> list;

    @BeforeEach
    void setUp() {
        list = new MyLinkedList<>();
    }

    @Test
    void testAdd() {
        list.add("Hello");
        assertEquals(1, list.size());
        assertEquals("Hello", list.get(0));
    }

    @Test
    void testAddByIndex() {
        list.add("Hello");
        list.add("World");
        list.add(1, "Awesome");
        assertEquals(3, list.size());
        assertEquals("Awesome", list.get(1));
    }

    @Test
    void testRemove() {
        list.add("Hello");
        list.add("Awesome");
        list.add("World");
        assertEquals("Awesome", list.remove(1));
        assertEquals(2, list.size());
        assertEquals("World", list.get(1));
    }

    @Test
    void testClear() {
        list.add("Hello");
        list.add("World");
        list.clear();
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }

    @Test
    void testSort() {
        list.add("Banana");
        list.add("Apple");
        list.add("Cherry");
        list.sort();
        assertEquals("Apple", list.get(0));
        assertEquals("Banana", list.get(1));
        assertEquals("Cherry", list.get(2));
    }

    @Test
    void testGetFirst() {
        list.add("Hello");
        list.add("World");
        assertEquals("Hello", list.getFirst());
    }

    @Test
    void testGetLast() {
        list.add("Hello");
        list.add("World");
        assertEquals("World", list.getLast());
    }
}