package AlgorithmsHT1;

public class SortUtils {
    /**
     * 0 1 2 3 4
     *
     * 5 4 1 0 1
     *
     * Сортировка выбором
     * @param array
     */
    public static void directSort(int[] array){
        for (int i = 0; i < array.length - 1; i++){
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++){
                if (array[j] < array[minIndex]){
                    minIndex = j;
                }
            }
            if (i != minIndex){
                int buf = array[i];
                array[i] = array[minIndex];
                array[minIndex] = buf;
            }
        }
    }

    public static void quickSort(int[] array){
        if (array == null)
            return;
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int start, int end){
        int left = start;
        int right = end;

        int middle = array[(start + end) / 2];

        do {
            while (array[left] < middle){
                left++;
            }

            while (array[right] > middle){
                right--;
            }

            if (left <= right){
                if (left < right){
                    int buf = array[left];
                    array[left] = array[right];
                    array[right] = buf;
                }
                left++;
                right--;
            }
        }
        while (left <= right);

        if (left < end){
            quickSort(array, left, end);
        }
        if (start < right){
            quickSort(array, start, right);
        }
    }


}
