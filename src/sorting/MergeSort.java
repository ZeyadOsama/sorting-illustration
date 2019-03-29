package sorting;

public class MergeSort {

    public static void sort(int[] array) {
        sort(array, new int[array.length], 0, array.length - 1);
    }

    public static void sort(int[] array, int start, int end) {
        sort(array, new int[array.length], start, end);
    }

    private static void sort(int[] array, int[] temp, int start, int end) {
        if (start >= end)
            return;

        int middle = (start + end) / 2;
        sort(array, temp, start, middle);
        sort(array, temp, middle + 1, end);
        mergeHalves(array, temp, start, end);
    }

    private static void mergeHalves(int[] array, int[] temp, int leftStart, int rightEnd) {
        int leftEnd = (rightEnd + leftStart) / 2;
        int rightStart = leftEnd + 1;
        int length = rightEnd - leftStart + 1;

        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        while (left <= leftEnd && right <= rightEnd) {
            if (array[left] <= array[right]) {
                temp[index] = array[left];
                left++;
            } else {
                temp[index] = array[right];
                right++;
            }
            index++;
        }
        System.arraycopy(array, left, temp, index, leftEnd - left + 1);
        System.arraycopy(array, right, temp, index, rightEnd - right + 1);
        System.arraycopy(temp, leftStart, array, leftStart, length);
    }
}
