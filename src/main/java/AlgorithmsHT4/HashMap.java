package AlgorithmsHT4;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class HashMap<K, V> implements Iterable<HashMap<K, V>.Entity> {


    private static final int INIT_BUCKET_COUNT = 16;
    private static final double LOAD_FACTOR = 0.5;

    private Bucket[] buckets;
    private int size;


    @Override
    public Iterator<HashMap<K, V>.Entity> iterator() {
        return new HashMapIterator();
    }

    class HashMapIterator implements Iterator<Entity> {

        /**
         * TODO: Необходимо доработать структуру класса HashMap, реализованную на семинаре.
         * У нас появились методы добавления, удаления и поиска элемента по ключу.
         * Добавить возможность перебора всех элементов нашей структуры данных,
         * необходимо добавить несколько элементов,
         * а затем перебрать все элементы таблицы используя цикл foreach.
         * Подумайте, возможно вам стоит обратиться к интерфейсу Iterable.
         *
         * @return
         */
        private int currentBucketIndex = 0;
        private Bucket.Node currentNode = null;

        public HashMapIterator() {
            findNextValidNode();
        }

        /**  поиск следующей  не пустой ноды в нашей хеш таблице
         * /
         */
        private void findNextValidNode() {
            while (currentBucketIndex < buckets.length) {
                if (buckets[currentBucketIndex] != null && buckets[currentBucketIndex].head != null) {
                    currentNode = buckets[currentBucketIndex].head;
                    return;
                }
                currentBucketIndex++;
            }
            currentNode = null;
        }

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public Entity next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements");
            }

            Entity result = currentNode.value;
            currentNode = currentNode.next;
            if (currentNode == null) {  // переход на следующую не пустую ноду
                currentBucketIndex++;
                findNextValidNode();
            }

            return result;
        }

    }


    /**
     * TODO: Вывести все элементы хеш-таблицы на экран через toString()
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Bucket bucket : buckets
        ) {
            if (bucket != null) {
                Bucket.Node node = bucket.head;
                stringBuilder.append('{');
                while (node != null) {
                    stringBuilder.append(node.value.key);
                    stringBuilder.append(':');
                    stringBuilder.append(node.value.value);
                    node = node.next;
                    if (node != null) stringBuilder.append(';');
                }
                stringBuilder.append('}');
                stringBuilder.append('\n');
            }
        }
        return stringBuilder.toString();
    }


    /**
     * Элемент хеш-таблицы
     */
    class Entity {

        /**
         * Ключ
         */
        K key;

        /**
         * Значение элемента
         */
        V value;

    }

    /**
     * Бакет, связный список
     */
    class Bucket {

        /**
         * Указатель на первый элемент связного списка
         */
        Node head;

        /**
         * Узел бакета (связного списка)
         */
        class Node {

            /**
             * Указатель на следующий элемент связного списка
             */
            Node next;

            /**
             * Значение узла, указывающее на элемент хеш-таблицы
             */
            Entity value;

        }

        public V add(Entity entity) {
            Node node = new Node();
            node.value = entity;

            if (head == null) {
                head = node;
                return null;
            }

            Node currentNode = head;
            while (true) {
                if (currentNode.value.key.equals(entity.key)) {
                    V buf = currentNode.value.value;
                    currentNode.value.value = entity.value;
                    return buf;
                }
                if (currentNode.next != null) {
                    currentNode = currentNode.next;
                } else {
                    currentNode.next = node;
                    return null;
                }
            }
        }

        public V remove(K key) {
            if (head == null)
                return null;
            if (head.value.key.equals(key)) {
                V buf = head.value.value;
                head = head.next;
                return buf;
            } else {
                Node node = head;
                while (node.next != null) {
                    if (node.next.value.key.equals(key)) {
                        V buf = node.next.value.value;
                        node.next = node.next.next;
                        return buf;
                    }
                    node = node.next;
                }
                return null;
            }
        }

        public V get(K key) {
            Node node = head;
            while (node != null) {
                if (node.value.key.equals(key))
                    return node.value.value;
                node = node.next;
            }
            return null;
        }

    }

    private int calculateBucketIndex(K key) {
        return Math.abs(key.hashCode()) % buckets.length;
    }

    private void recalculate() {
        size = 0;
        Bucket[] old = buckets;
        buckets = new HashMap.Bucket[old.length * 2];
        for (Bucket bucket : old) {
            if (bucket != null) {
                Bucket.Node node = bucket.head;
                while (node != null) {
                    put(node.value.key, node.value.value);
                    node = node.next;
                }
            }
        }
    }

    public V put(K key, V value) {
//        if (size >= buckets.length * LOAD_FACTOR) {
//            recalculate();
//        }
        int index = calculateBucketIndex(key);
        Bucket bucket = buckets[index];
        if (bucket == null) {
            bucket = new Bucket();
            buckets[index] = bucket;
        }

        Entity entity = new Entity();
        entity.key = key;
        entity.value = value;

        V buf = bucket.add(entity);
        if (buf == null) {
            size++;
        }
        return buf;
    }

    public V get(K key) {
        int index = calculateBucketIndex(key);
        Bucket bucket = buckets[index];
        if (bucket == null)
            return null;
        return bucket.get(key);
    }

    public V remove(K key) {
        int index = calculateBucketIndex(key);
        Bucket bucket = buckets[index];
        if (bucket == null)
            return null;
        V buf = bucket.remove(key);
        if (buf != null) {
            size--;
        }
        return buf;
    }

    public HashMap() {
        buckets = new HashMap.Bucket[INIT_BUCKET_COUNT];
    }

    public HashMap(int initCount) {
        buckets = new HashMap.Bucket[initCount];
    }


}

