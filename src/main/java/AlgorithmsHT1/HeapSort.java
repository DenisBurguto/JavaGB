package AlgorithmsHT1;

public class HeapSort {

    public void sort(int[] array) {
        int n = array.length;

        // Build heap (rearrange array) the first index
        // of a non-leaf node is given by n/2 - 1
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // call max heapify on the reduced heap
            heapify(array, i, 0);
        }
    }


    static void heapify(int[] array, int n, int i) {// n - size of heap , subtree rooted at index i.
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // left child index in array considered as heap
        int right = 2 * i + 2; // right child index in array considered as heap

        // If left child is larger than root
        if (left < n && array[left] > array[largest]) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < n && array[right] > array[largest]) {
            largest = right;
        }

        // If largest is not root
        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            // Recursively heapify the affected subtree
            heapify(array, n, largest);

        }
    }
}
