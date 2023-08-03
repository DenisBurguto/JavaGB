package AlgorithmsHT1;

public class Program {
    public static void main(String[] args) {
        int[] array = ArrayUtils.prepareArray(30);
        ArrayUtils.printArray(array);
        HeapSort heap = new HeapSort();
        heap.sort(array);
        ArrayUtils.printArray(array);


    }
}
