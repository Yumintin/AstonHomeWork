package org.example;

import org.example.CustomList.MyArrayList;
import org.example.CustomList.MyLinkedList;
import org.example.CustomList.MyList;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        // Проверка MyArrayList
        System.out.println("MyArrayList");
        MyList<Integer> arrayList = new MyArrayList<>();

        // Добавление элементов
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);
        System.out.println("После добавления элементов: " + arrayListToString(arrayList)); // [10, 20, 30]

        // Добавление элемента по индексу
        arrayList.add(1, 15);
        System.out.println("После добавления 15 по индексу 1: " + arrayListToString(arrayList)); // [10, 15, 20, 30]

        // Получение элемента по индексу
        System.out.println("Элемент по индексу 2: " + arrayList.get(2)); // 20

        // Удаление элемента по индексу
        System.out.println("Удаленный элемент по индексу 1: " + arrayList.remove(1)); // 15
        System.out.println("После удаления элемента: " + arrayListToString(arrayList)); // [10, 20, 30]

        // Проверка размера списка
        System.out.println("Размер списка: " + arrayList.size()); // 3

        // Проверка, пуст ли список
        System.out.println("Список пуст? " + arrayList.isEmpty()); // false

        // Сортировка списка
        arrayList.add(5);
        System.out.println("До сортировки: " + arrayListToString(arrayList)); // [10, 20, 30, 5]
        arrayList.sort();
        System.out.println("После сортировки: " + arrayListToString(arrayList)); // [5, 10, 20, 30]

        // Очистка списка
        arrayList.clear();
        System.out.println("После очистки: " + arrayListToString(arrayList)); // []
        System.out.println("Список пуст? " + arrayList.isEmpty()); // true

        // Проверка MyLinkedList
        System.out.println("\nMyLinkedList");
        MyList<String> linkedList = new MyLinkedList<>();

        // Добавление элементов
        linkedList.add("Hello");
        linkedList.add("World");
        linkedList.add("Java");
        System.out.println("После добавления элементов: " + linkedListToString(linkedList)); // [Hello, World, Java]

        // Добавление элемента по индексу
        linkedList.add(1, "Awesome");
        System.out.println("После добавления 'Awesome' по индексу 1: " + linkedListToString(linkedList)); // [Hello, Awesome, World, Java]

        // Получение элемента по индексу
        System.out.println("Элемент по индексу 2: " + linkedList.get(2)); // World

        // Удаление элемента по индексу
        System.out.println("Удаленный элемент по индексу 1: " + linkedList.remove(1)); // Awesome
        System.out.println("После удаления элемента: " + linkedListToString(linkedList)); // [Hello, World, Java]

        // Проверка размера списка
        System.out.println("Размер списка: " + linkedList.size()); // 3

        // Проверка, пуст ли список
        System.out.println("Список пуст? " + linkedList.isEmpty()); // false

        // Сортировка списка
        linkedList.add("Algorithm");
        System.out.println("До сортировки: " + linkedListToString(linkedList)); // [Hello, World, Java, Algorithm]
        linkedList.sort();
        System.out.println("После сортировки: " + linkedListToString(linkedList)); // [Algorithm, Hello, Java, World]

        // Очистка списка
        linkedList.clear();
        System.out.println("После очистки: " + linkedListToString(linkedList)); // []
        System.out.println("Список пуст? " + linkedList.isEmpty()); // true
    }

    /**
     * Вспомогательный метод для вывода элементов MyArrayList в виде строки.
     *
     * @param list список для вывода
     * @return строка с элементами списка
     */
    private static String arrayListToString(MyList<?> list) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i < list.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * Вспомогательный метод для вывода элементов MyLinkedList в виде строки.
     *
     * @param list список для вывода
     * @return строка с элементами списка
     */
    private static String linkedListToString(MyList<?> list) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i < list.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}

