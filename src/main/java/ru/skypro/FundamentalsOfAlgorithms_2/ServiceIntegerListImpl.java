package ru.skypro.FundamentalsOfAlgorithms_2;

import ru.skypro.FundamentalsOfAlgorithms_2.exception.NotEmptyException;
import ru.skypro.FundamentalsOfAlgorithms_2.exception.OutsideTheArrayException;
import ru.skypro.FundamentalsOfAlgorithms_2.exception.ThereIsNoSuchElementException;

import java.util.Arrays;

public class ServiceIntegerListImpl implements IntegerList {

    private Integer[] array;
    public int size;


    public ServiceIntegerListImpl(int sizeArray) {
        this.array = new Integer[sizeArray];
    }


    @Override
    public Integer add(Integer item) {
        if (item == null) {
            throw new NotEmptyException("не должно быть пусто");
        }
        array[size++] = item;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        checkRange(index);
        System.arraycopy(array, index, array, index + 1, size - index); //сдвигается вправо
        array[index] = item;
        size++;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        checkRange(index);
        array[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        int index = indexOf(item);
        if (index == -1) {
            throw new ThereIsNoSuchElementException("такого элемента не существует!");
        }
        return remove(index);
    }

    @Override
    public Integer remove(int index) {
        checkRange(index);
        Integer del = array[index];
        if (index != size - 1) {
            System.arraycopy(array, index, array, index - 1, size - index - 1); // сдвигается влево
        }
        array[size - 1] = null;
        size--;
        return del;
    }

    @Override
    public boolean contains(Integer item) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = size - 1; i >= 0; i--) {
            if (array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        checkRange(index);
        return array[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        if (this == otherList) {
            return true;
        }
        if (otherList == null) {
            throw new NotEmptyException("не может быть равным нулю");
        }
        if (size != otherList.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!array[i].equals(otherList.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        Arrays.fill(array, null);

    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(array, array.length);

    }

    private void grow() {                                             // расширение массива
        Integer[] newArray = new Integer[(int)(array.length * 1.5)];
        System.arraycopy(array, 0, newArray , 0, array.length);
        array = newArray;
    }

    private void checkRange(int index) {
        if (index < 0 || index >= size) {
            throw new OutsideTheArrayException("за пределами массива");
        }
    }
}
