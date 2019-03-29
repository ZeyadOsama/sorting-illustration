package sorting;

public class SelectionSort {

    public static void sort(int[] list) {
        int n = list.length;

        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++)
                if (list[j] < list[min_idx])
                    min_idx = j;

            int temp = list[min_idx];
            list[min_idx] = list[i];
            list[i] = temp;
        }
    }

    public static class Illustration {

        public static Integer[] sortOneTime(Integer[] list, int currentIndex) {
            int currentMax = list[0];
            int currentMaxIndex = 0;


            for (int i = 1; i <= currentIndex; i++) {
                if (currentMax < list[i]) {
                    currentMax = list[i];
                    currentMaxIndex = i;
                }
            }

            if (currentMaxIndex != currentIndex) {
                list[currentMaxIndex] = list[currentIndex];
                list[currentIndex] = currentMax;
            }
            return list;
        }
    }
}
