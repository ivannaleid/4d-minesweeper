import java.util.ArrayList;

public class SelectionSort extends BaseSort {
    public ArrayList<Integer> sort(ArrayList<Integer> integerArrayList) {
        int numCompares = 0;
        int[] intArray = integerArrayListToIntArray(integerArrayList);

        for (int j = 0; j < intArray.length - 1; j++) {
            int m = j;

            for (int k = j + 1; k < intArray.length; k++) {
                numCompares++;

                if (intArray[k] < intArray[m]) {
                    m = k;
                }
            }

            int temp = intArray[m];
            intArray[m] = intArray[j];
            intArray[j] = temp;


        }
        return intArrayToIntegerArrayList(intArray);
    }
}
