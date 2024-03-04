package ru.skypro.FundamentalsOfAlgorithms_2;

import org.junit.jupiter.api.Test;
import ru.skypro.FundamentalsOfAlgorithms_2.exception.NotEmptyException;
import ru.skypro.FundamentalsOfAlgorithms_2.exception.OutsideTheArrayException;

import static org.junit.jupiter.api.Assertions.*;

class ServiceIntegerListImplTest {

    ServiceIntegerListImpl list = new ServiceIntegerListImpl(10);

    @Test
    void addNotNullTest() {
        assertThrows(NotEmptyException.class, () -> list.add(null));
    }

    @Test
    void addElementTest() {
        var result = list.add(1);
        assertEquals(result, 1);
    }

    @Test
    void addSizeIncreaseTest() {
        var result = list.add(1);
        assertEquals(list.size(), 1);
    }

    @Test
    void indexOfTest() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        assertEquals(list.indexOf(1), 0);

        assertEquals(list.indexOf(10), -1);
    }

    @Test
    void lastIndexOfTest() {
        list.add(1);
        list.add(2);
        list.add(1);
        list.add(3);
        assertEquals(list.lastIndexOf(3), 3);

        assertEquals(list.lastIndexOf(20), -1);
    }

    @Test
    void getTest() {
        var result = list.add(1);
        assertEquals(list.get(0), 1);
    }

    @Test
    void testOutsideTheArrayException() {
        assertThrows(OutsideTheArrayException.class, () -> list.get(111));
    }

    @Test
    void setTest() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(list.set(1, 2), 2);
    }

    @Test
    void setExceptionTest() {
        list.add(1);
        list.add(2);
        list.add(3);

        assertThrows(OutsideTheArrayException.class, () ->  list.set(3, 4));
    }
}