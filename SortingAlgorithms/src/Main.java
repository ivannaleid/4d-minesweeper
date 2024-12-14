import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many numbers do you want in your array (5 is recommended): ");
        int arraySize = scanner.nextInt();

        BaseSort baseSort = new BaseSort();
        ArrayList<Integer> arrayToSort = new ArrayList<>();
        arrayToSort = baseSort.createArray(arraySize);
        System.out.println("randomized array that will be sorted: " + arrayToSort);
        ArrayList<Integer> arrayToSortSave = new ArrayList<>(arrayToSort);


        StalinSort stalin = new StalinSort();
        System.out.println("Stalin Sort: " + stalin.sort(arrayToSort));
        baseSort.resetArray(arrayToSort, arrayToSortSave);

        RandomSort random = new RandomSort();
        System.out.println("Random Sort: " + random.sort(arrayToSort));
        baseSort.resetArray(arrayToSort, arrayToSortSave);

        AddingSort adding = new AddingSort();
        System.out.println("Adding Sort: " + adding.sort(arrayToSort));
        baseSort.resetArray(arrayToSort, arrayToSortSave);

        MinMaxSort minMax = new MinMaxSort();
        System.out.println("Min Max Sort: " + minMax.sort(arrayToSort));
        baseSort.resetArray(arrayToSort, arrayToSortSave);

        MergeSort merge = new MergeSort();
        System.out.println("Merge Sort: " + merge.sort(arrayToSort, 0, arrayToSort.size() - 1));
        baseSort.resetArray(arrayToSort, arrayToSortSave);

        SelectionSort selection = new SelectionSort();
        System.out.println("Seletion Sort: " + selection.sort(arrayToSort));
        baseSort.resetArray(arrayToSort, arrayToSortSave);

        ManualSort manual = new ManualSort();
        System.out.println("Manual Sort: " + manual.sort(arrayToSort));
        baseSort.resetArray(arrayToSort, arrayToSortSave);




    }
}