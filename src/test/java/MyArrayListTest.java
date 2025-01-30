import org.example.CustomList.MyArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {
    private MyArrayList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new MyArrayList<>();
    }

    @Test
    void testAdd() {
        list.add(10);
        assertEquals(1, list.size());
        assertEquals(10, list.get(0));
    }

    @Test
    void testAddByIndex() {
        list.add(10);
        list.add(20);
        list.add(1, 15);
        assertEquals(3, list.size());
        assertEquals(15, list.get(1));
    }

    @Test
    void testRemove() {
        list.add(10);
        list.add(20);
        list.add(30);
        assertEquals(20, list.remove(1));
        assertEquals(2, list.size());
        assertEquals(30, list.get(1));
    }

    @Test
    void testClear() {
        list.add(10);
        list.add(20);
        list.clear();
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }

    @Test
    void testSort() {
        list.add(30);
        list.add(10);
        list.add(20);
        list.sort();
        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(30, list.get(2));
    }
}