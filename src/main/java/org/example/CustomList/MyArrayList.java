package org.example.CustomList;


import java.util.Arrays;

/**
 * MyArayList - реализация списка на основе массива
  * @param <E> тип элементов в списке
 */
public class MyArrayList<E> implements MyList<E> {
    private static final int DEFAULT_CAPACITY =10;//Начальная емкость массива
    private Object[] elements;//Массив для хранения элементов
    private int size;//Текущее количество элементов в списке

    /**
     * Создает пустой список с начальной емкостью по умолчанию
     */
    public MyArrayList() {
        this.elements = new Object[DEFAULT_CAPACITY]; //Создаем массив с начальной емкостью
        this.size = 0; //Указываем, что пуст (0 элементов)
    }

    /**
     * Добавляет элемент в конец списка.
     * Если массив заполнен, его емкость увеличивается в 1,5 раза
     *
     * @param element элемент для добавления
     */
    @Override
    public void add(E element) {
        if (size == elements.length) { //Если мы на последнем элементе массива
            increaseCapacity(); //Вызываем метод для увеличения размера массива
        }
        elements[size++] = element;//Добавляем элемент в массив, увеличиваем количество элементов в списке
    }

    /**
     * Добавляет элемент по указанному индексу.
     * Сдвигает существующие элементы вправо
     *
     * @param index индекс, по которому добавится элемент
     * @param element элемент для добавления
     */
    @Override
    public void add(int index, E element) {
        checkIndex(index); //Проверка индекса на отрицательное значение или выход за границы массива
        if (size == elements.length) { //Если мы на последнем элементе массива
            increaseCapacity(); //Вызываем метод для увеличения размера массива
        }
        System.arraycopy(elements, index, elements, index + 1, size - index); //Сдвигаем элементы на 1 вправо
        elements[index] = element; //Добавляем элемент
        size++; //Указываем увеличение количества элементов
    }

    /**
     * Возвращает элемент по указанному индеку
     *
     * @param index индекс элемента
     * @return элемент по указанному индексу
     */
    @Override
    public E get(int index) {
        checkIndex(index); //Проверка индекса на отрицательное значение или выход за границы массива
        return (E) elements[index];//Возвращаем элемент
    }

    /**
     * Удаляет элемент по указанному индексу.
     * Сдвигает оставшиеся элементы влево
     *
     * @param index индекс элемента
     * @return удаленный элемент
     */
    @Override
    public E remove(int index) {
        checkIndex(index); //Проверка индекса на отрицательное значение или выход за границы массива
        E removedElement = (E) elements[index]; //Берем элемент по указанному индексу
        System.arraycopy(elements, index + 1, elements, index, size - index - 1); //Сшиваем массив без выбранного элемента
        elements[size--] = null; //Очищаем последний элемент
        return removedElement; //Возвращаем элемент
    }

    /**
     * Очищает список, удаляя все элементы
     */
    @Override
    public void clear() {
        for (int i = 0; i < size; i++) { //Проходимся счетчиком по массиву и ставим везде null.
            elements[i] = null;
        }
        size = 0; //Указываем нулевое количество элементов
    }

    /**
     * Сортирует список
     */
    @Override
    public void sort() {
        Arrays.sort((E[]) elements, 0, size);
    }

    /**
     * Возвращает количество элементов в списке.
     *
     * @return количество элементов
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Проверяет, пуст ли список
     *
     * @return true, если список пуст, иначе false
     */
    @Override
    public boolean isEmpty() {
        return size==0;
    }

    /**
     * Увеличивает емкость массива в 1.5 раза
     */
    private void increaseCapacity() {
        int newCapacity= (int) (elements.length*1.5); //Создаем новую длину для массива (1.5 от изначального)
        elements= Arrays.copyOf(elements, newCapacity); //Пересоздаем массив с новой длиной
    }

    /**
     * Проверяет, не является ли указанный индекс отрицательным или выходящим ща границы массива
     * @param index указанный индекс
     */
    private void checkIndex(int index){
        if (index < 0 || index > size) { //Если указанный индекс отрицательный или выходит за  границы массива
            throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size); //Выкидываем исключение
        }
    }
}
