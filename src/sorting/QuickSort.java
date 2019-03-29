package sorting;

public class QuickSort {

    public static void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    public static void sort(int[] array, int start, int end) {
        if (start < end) {
            int pi = partition(array, start, end);
            sort(array, start, pi - 1);
            sort(array, pi + 1, end);
        }
    }

    private static int partition(int[] list, int low, int high) {
        int pivot = list[high];
        int i = (low - 1);

        for (int j = low; j < high; j++)
            if (list[j] <= pivot) {
                i++;

                int temp = list[i];
                list[i] = list[j];
                list[j] = temp;
            }

        int temp = list[i + 1];
        list[i + 1] = list[high];
        list[high] = temp;

        return i + 1;
    }
}