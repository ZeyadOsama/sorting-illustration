package sorting;

public class BubbleSort {

    public static void sort(int[] array) {
        int length = array.length;

        for (int i = 0; i < length - 1; i++)
            for (int j = 0; j < length - i - 1; j++)
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
    }

    public static class Illustration {

        public static Integer[] sortOneTime(Integer[] list) {
            for (int i = 0; i < list.length - 1; i++)
                if (list[i] > list[i + 1]) {
                    int temp = list[i + 1];
                    list[i + 1] = list[i];
                    list[i] = temp;
                }
            return list;
        }
    }
}
