package sorting;

public final class Sorting {


    public final static String BUBBLE_SORT = "Bubble Sort";
    public final static String SELECTION_SORT = "Selection Sort";
    public final static String INSERTION_SORT = "Insertion Sort";
    public final static String QUICK_SORT = "Quick Sort";
    public final static String MERGE_SORT = "Merge Sort";
    public final static String HEAP_SORT = "Heap Sort";

    public final static String[] SORTING_TECHNIQUES =
            {BUBBLE_SORT, SELECTION_SORT, INSERTION_SORT, QUICK_SORT, MERGE_SORT, HEAP_SORT};

    public static Integer[] sortOneTime(String sortingTechniques, Integer[] list, int currentIndex) {
        switch (sortingTechniques) {
            case BUBBLE_SORT:
                return BubbleSort.Illustration.sortOneTime(list);

            case SELECTION_SORT:
                return SelectionSort.Illustration.sortOneTime(list, currentIndex);

            default:
                return null;
        }

    }
}
