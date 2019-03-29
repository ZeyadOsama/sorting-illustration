package test;

import illustrations.Plot;
import sorting.*;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Test {

    public final static int POSITION_BUBBLE_SORT = 0;
    public final static int POSITION_SELECTION_SORT = 1;
    public final static int POSITION_INSERTION_SORT = 2;
    public final static int POSITION_QUICK_SORT = 3;
    public final static int POSITION_MERGE_SORT = 4;
    public final static int POSITION_HEAP_SORT = 5;

    public final static String FORMAT = "png";

    private final int TEST_NUM = 3;
    private final String TEST_NAME;

    private int[] array;
    private double[] xValues;

    private ArrayList<double[]> timeElapsed;

    private double[] timeBubbleSort;
    private double[] timeQuickSort;
    private double[] timeInsertionSort;
    private double[] timeMergeSort;
    private double[] timeHeapSort;
    private double[] timeSelectionSort;
    private Plot plot;

    public Test(String testName) {
        TEST_NAME = testName;
        array = new int[TEST_NUM * 100];
        timeElapsed = new ArrayList<>(6);
        xValues = new double[TEST_NUM];

        timeBubbleSort = new double[TEST_NUM];
        timeQuickSort = new double[TEST_NUM];
        timeInsertionSort = new double[TEST_NUM];
        timeMergeSort = new double[TEST_NUM];
        timeHeapSort = new double[TEST_NUM];
        timeSelectionSort = new double[TEST_NUM];

        timeBubbleSort[0] = 0;
        timeQuickSort[0] = 0;
        timeInsertionSort[0] = 0;
        timeMergeSort[0] = 0;
        timeHeapSort[0] = 0;
        timeSelectionSort[0] = 0;
        xValues[0] = 0;
    }

    public void start() {
        long startTime;
        long endTime;
        long timeElapsed;
        int[] tempArray;

        for (int i = 1; i < TEST_NUM; i++) {
            int iterator = 0;
            for (int j = i * 100; j > 0; j--)
                array[iterator++] = j;

            tempArray = array;
            startTime = System.nanoTime();
            BubbleSort.sort(tempArray);
            endTime = System.nanoTime();
            timeElapsed = endTime - startTime;
            timeBubbleSort[i] = timeElapsed;

            tempArray = array;
            startTime = System.nanoTime();
            QuickSort.sort(tempArray);
            endTime = System.nanoTime();
            timeElapsed = endTime - startTime;
            timeQuickSort[i] = timeElapsed;

            tempArray = array;
            startTime = System.nanoTime();
            InsertionSort.sort(tempArray);
            endTime = System.nanoTime();
            timeElapsed = endTime - startTime;
            timeInsertionSort[i] = timeElapsed;

            tempArray = array;
            startTime = System.nanoTime();
            MergeSort.sort(tempArray);
            endTime = System.nanoTime();
            timeElapsed = endTime - startTime;
            timeMergeSort[i] = timeElapsed;

            tempArray = array;
            startTime = System.nanoTime();
            HeapSort.sort(tempArray);
            endTime = System.nanoTime();
            timeElapsed = endTime - startTime;
            timeHeapSort[i] = timeElapsed;

            tempArray = array;
            startTime = System.nanoTime();
            SelectionSort.sort(tempArray);
            endTime = System.nanoTime();
            timeElapsed = endTime - startTime;
            timeSelectionSort[i] = timeElapsed;

            xValues[i] = i;
        }

        this.timeElapsed.add(POSITION_BUBBLE_SORT, timeBubbleSort);
        this.timeElapsed.add(POSITION_SELECTION_SORT, timeSelectionSort);
        this.timeElapsed.add(POSITION_INSERTION_SORT, timeInsertionSort);
        this.timeElapsed.add(POSITION_QUICK_SORT, timeQuickSort);
        this.timeElapsed.add(POSITION_MERGE_SORT, timeMergeSort);
        this.timeElapsed.add(POSITION_HEAP_SORT, timeHeapSort);
    }

    public double[] getTimeElapsed(int position) {
        return timeElapsed.get(position);
    }

    public double[] getXValues() {
        return xValues;
    }

    public void plot() {
        plot = Plot.plot(Plot.plotOpts()
                .title(TEST_NAME)
                .legend(Plot.LegendFormat.BOTTOM))
                .xAxis("ELEMENTS", Plot.axisOpts().range(0, 0.00001))
                .yAxis("TIME", Plot.axisOpts().range(0, 10))
                .series(Sorting.HEAP_SORT,
                        Plot.data().xy(xValues, getTimeElapsed(Test.POSITION_HEAP_SORT)),
                        Plot.seriesOpts().color(Color.BLACK))
                .series(Sorting.INSERTION_SORT,
                        Plot.data().xy(xValues, getTimeElapsed(Test.POSITION_INSERTION_SORT)),
                        Plot.seriesOpts().color(Color.RED))
                .series(Sorting.SELECTION_SORT,
                        Plot.data().xy(xValues, getTimeElapsed(Test.POSITION_SELECTION_SORT)),
                        Plot.seriesOpts().color(Color.BLUE))
                .series(Sorting.BUBBLE_SORT,
                        Plot.data().xy(xValues, getTimeElapsed(Test.POSITION_BUBBLE_SORT)),
                        Plot.seriesOpts().color(Color.YELLOW))
                .series(Sorting.MERGE_SORT,
                        Plot.data().xy(xValues, getTimeElapsed(Test.POSITION_MERGE_SORT)),
                        Plot.seriesOpts().color(Color.MAGENTA))
                .series(Sorting.QUICK_SORT,
                        Plot.data().xy(xValues, getTimeElapsed(Test.POSITION_QUICK_SORT)),
                        Plot.seriesOpts().color(Color.ORANGE));
    }

    public void savePlottingAsImage() {
        try {
            plot.save(TEST_NAME, FORMAT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


