package org.example.CustomList;

/**
 * MyLinkedList - реализация списка на основе связного списка.
 * Каждый узел содержит ссылку на следующий узел.
 *
 * @param <E> тип элементов в списке
 */
public class MyLinkedList<E> implements MyList<E> {
    private static class Node<E> { //Создаем класс для узлов
        E element; //Элемент узла
        Node<E> next; //Ссылка на следующий узел

        Node(E element) {
            this.element = element;
            this.next = null;
        }
    }

    private Node<E> head; //Первый узел списка
    private Node<E> tail; //Последний узел списка
    private int size; //Количество узлов в списке

    /**
     * Создает пустой список
     */
    public MyLinkedList(){
        this.head=null;
        this.tail=null;
        this.size=0;
    }

    /**
     * Добавляет узел в конец списка
     *
     * @param element элемент для добавления
     */
    @Override
    public void add(E element) {
        Node<E> newNode = new Node<>(element); //Создаем новый узел
        if (tail == null) { //Если последний узел = null, то список пуст
            head = tail = newNode; //Первый узел=последний узел=новый узел
        } else {
            tail.next = newNode; //Текущий узел теперь ссылается на новый узел
            tail = newNode; //Теперь новый узел стал последним
        }
        size++; //Увеличиваем размер списка
    }

    /**
     * Добавляет узел по указанному индексу
     *
     * @param index индекс, по которому добавится элемент
     * @param element элемент для добавления
     */
    @Override
    public void add(int index, E element) {
        checkIndex(index); //Проверка индекса на отрицательное значение или выход за границы массива
        if (index == size) { //Если индекс указывает на последний узел
            add(element); //Просто добавляем его в конец списка
            return;
        }
        Node<E> newNode = new Node<>(element); //Создаем новый узел
        if (index == 0) { //Если индекс указывает на первый узел
            newNode.next = head; //Новый узел делает ссылку на первый узел
            head = newNode; //Теперь новый узел становится первым узлом
        } else { //Иначе добавляем новый узел после узла[индес-1] и меняем ссылки (новый узел ссылается на тот, на который ссылается узел[индекс-1], а узел [индекс-1] теперь ссылается на новый)
            Node<E> prev = getNode(index - 1);
            newNode.next = prev.next;
            prev.next = newNode;
        }
        size++; //Обновляем количество элементов в массиве
    }

    /**
     * Возвращает элемент по указанному индексу
     *
     * @param index индекс элемента
     * @return элемент по указанному индексу
     */
    @Override
    public E get(int index) {
        return getNode(index).element; //Просто вызываем отсчитывающий индексы метод
    }

    /**
     * Удаляет узел по указанному индексу
     * @param index индекс элемента
     * @return удаленный элемент
     */
    @Override
    public E remove(int index) {
        checkIndex(index); //Проверка индекса на отрицательное значение или выход за границы массива
        Node<E> removedNode; //Вводим переменную для удаляемого узла
        if (index == 0) { //Если индекс указывает на первый узел
            removedNode = head; //Передаем в удаляемый узел данные первого узла
            head = head.next; //Первым узлом ставим следующий, "отвязываем"
            if (head == null) { //Если был всего один элемент в списке
                tail = null; //Очищаем список
            }
        } else { //"Выдергиваем" узел из цепи, перепревязывая ссылки соседних узлов: предыдущий от индекса узел теперь ссылается на тот, на который ссылается удаляемый
            Node<E> prev = getNode(index - 1); //Находим узел, стоящий перед удаляемым
            removedNode = prev.next; //По ссылке обозначаем удаляемый узел
            prev.next = removedNode.next; //Передаем ссылку удаляемого узла тому, что был перед ним
            if (removedNode == tail) { //если это удаляемый узел - последний узел, то передаем статус "последнего узла" перед ним стоящему
                tail = prev;
            }
        }
        size--;
        return removedNode.element;
    }

    /**
     * Очищает список, удаляя все элементы
     */
    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    /**
     * Сортирует список
     */
    @Override
    public void sort() {
        //Реализация сортировки (пузырьком)
        if(size<=1) return; //Если список из 1 узла или пуст, останавливаемся
        boolean swapped; //Переменная для отслеживания перестановки узлов
        do { //Пока есть перестановки, делаем алгоритм
            swapped=false; //Сброс флага
            Node<E> current=head; //Начинаем сортировку с первого узла
            while(current.next!=null){ //Проходимся по всему массиву
                if(((Comparable<E>)current.element).compareTo(current.next.element)>0){ //Сравнение элементов методом compareTo(возвращает >0 если current.element больше current.next.element)
                    E temp =current.element; //Временная переменная равна текущему элементу
                    current.element=current.next.element; //Текущий элемент равен следующему
                    current.next.element=temp; //Следующий элемент равен временной переменной
                    swapped=true; //Ставим флаг что была перестановка
                }
                current=current.next; //Переходим к следующему узлу
            }
        }while ((swapped));
    }

    /**
     * Возвращает количество элементов в списке
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
     * Возвращает узел по указанному индексу
     *
     * @param index индекс узла
     * @return узел по указанному индексу
     */
    private Node<E> getNode(int index) {
        checkIndex(index); //Проверка индекса на отрицательное значение или выход за границы массива
        Node<E> current = head; //Начинаем считать с первого узла
        for (int i = 0; i < index; i++) {
            current = current.next; //Отсчитываем элементы до нужного индекса
        }
        return current;
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
