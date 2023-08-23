package AlgorithmsHT3;

import java.util.Comparator;


/**
 * Связный список
 *
 * @param <T>
 */
public class LinkedList<T> {

    /**
     * Указатель на первый элемент связного списка
     */
    public Node head;

    /**
     * Узел связного списка
     */
    public class Node {

        /**
         * Ссылка на следующий узел
         */
        public Node next;

        /**
         * Значение узла
         */
        public T value;

    }


    /**
     * Домашнее задание - метод разворота связанного списка
     */
    public void reverseList() {

        if (head == null || head.next == null) {   // пустой список или список с одной нодой
            return;
        }
        Node currentNode = head;
        int nodesCount = 0;
        while (currentNode != null) {
            nodesCount++;
            currentNode = currentNode.next;
        }
        int changes = 0;
        while (nodesCount / 2 - changes > 0) { // не трогаем центральный элемент при нечетном кол-ве
            Node first = head;
            currentNode = head;
            for (int i = 0; i < changes; i++) { // получаем начальную ноду для обмена
                first = first.next;
            }
            for (int i = 1; i < nodesCount - changes; i++) { // получаем конечную ноду для обмена
                currentNode = currentNode.next;
            }
            T buf = currentNode.value;
            currentNode.value = first.value;
            first.value = buf;
            changes++;

        }
    }


    /**
     * Добавление нового элемента в начало связного списка
     *
     * @param value значение
     */
    public void addFirst(T value) {
        Node node = new Node();
        node.value = value;
        if (head != null) {
            node.next = head;
        }
        head = node;
    }

    /**
     * Удалить первый элемент связного списка
     */
    public void removeFirst() {
        if (head != null) {
            head = head.next;
        }
    }

    /**
     * Поиск элемента в связном списке по значению
     *
     * @param value
     * @return
     */
    public boolean contains(T value) {
        Node node = head;
        while (node != null) {
            if (node.value.equals(value))
                return true;
            node = node.next;
        }
        return false;
    }

    public void sort(Comparator<T> comparator) {
        Node node = head;
        while (node != null) {

            Node minValueNode = node;

            Node node2 = node.next;
            while (node2 != null) {

                if (comparator.compare(minValueNode.value, node2.value) > 0) {
                    minValueNode = node2;
                }
                node2 = node2.next;
            }

            if (minValueNode != node) {
                T buf = node.value;
                node.value = minValueNode.value;
                minValueNode.value = buf;
            }

            node = node.next;
        }
    }

    /**
     * Добавить элемент в конец связного списка
     *
     * @param value значение
     */
    public void addLast(T value) {
        Node node = new Node();
        node.value = value;
        if (head == null) {
            head = node;
        } else {
            Node lastNode = head;
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            lastNode.next = node;
        }
    }

    /**
     * Удалить последний элемент связного списка
     */
    public void removeLast() {
        if (head == null)
            return;
        Node node = head;

        while (node.next != null) {
            if (node.next.next == null) {
                node.next = null;
                return;
            }
            node = node.next;
        }

        head = null;

    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
        Node node = head;
        while (node != null) {
            stringBuilder.append(node.value);
            node = node.next;
            if (node != null)
                stringBuilder.append('\n');
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}

