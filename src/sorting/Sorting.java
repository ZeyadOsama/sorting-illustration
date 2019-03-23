package sorting;

public final class Sorting {

    public final static String BUBBLE_SORT = "Bubble Sort";
    public final static String SELECTION_SORT = "Selection Sort";

    public static Integer[] sortOneTime(String sortingTechniques, Integer[] list, int currentIndex) {
        switch (sortingTechniques) {
            case BUBBLE_SORT:
                return BubbleSort.sortOneTime(list);

            case SELECTION_SORT:
                return SelectionSort.sortOneTime(list, currentIndex);

            default:
                return null;
        }

    }

    private static class BubbleSort {

        private static Integer[] sortOneTime(Integer[] list) {
            for (int i = 0; i < list.length - 1; i++)
                if (list[i] > list[i + 1]) {
                    int temp = list[i + 1];
                    list[i + 1] = list[i];
                    list[i] = temp;
                }
            return list;
        }
    }

    private static class SelectionSort {

        private static Integer[] sortOneTime(Integer[] list, int currentIndex) {
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
