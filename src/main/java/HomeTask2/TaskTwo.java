package HomeTask2;

import java.io.FileWriter;
import java.io.IOException;

public class TaskTwo {
    public static void main(String[] args) {
        int[] array = {5, 2, 8, 12, 1};
        bubbleSort(array);

    }

    private static void bubbleSort(int[] array) {
        boolean swapped;
        try {
            FileWriter logFile = new FileWriter("sort_log.txt");

            for (int i = 0; i < array.length - 1; i++) {
                swapped = false;

                for (int j = 0; j < array.length - i - 1; j++) {
                    if (array[j] > array[j + 1]) {
                        int temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                        swapped = true;
                    }
                }

                logIteration(logFile, i + 1, array);


                if (!swapped) {
                    break;
                }
            }

            logFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void logIteration(FileWriter logFile, int iteration, int[] array) throws IOException {
        logFile.write("Iteration " + iteration + ": ");
        for (int i = 0; i < array.length; i++) {
            logFile.write(array[i] + " ");
        }
        logFile.write("\n");
    }
}
