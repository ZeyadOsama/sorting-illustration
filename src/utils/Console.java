package utils;

public class Console<T> {

    public void printList(T[] list) {
        for (T i : list)
            System.out.print(i + " ");
        System.out.println();
    }
}
