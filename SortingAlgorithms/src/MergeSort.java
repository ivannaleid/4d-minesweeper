import java.util.ArrayList;

// classic merge sort nothing strange here
// 1, 3, 5, 2, 4
// 1, 2, 3, 4, 5
public class MergeSort extends BaseSort {
    public static void mergeSort(int[] numList, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            mergeSort(numList, left, middle);
            mergeSort(numList, middle + 1, right);

            merge(numList, left, middle, right);
        }
    }

    /*
     * Splits the 1D array numList into two sub-arrays and merges them together in order
     */
    public static void merge(int[] numList, int left, int middle, int right) {
        // create temporary arrays
        int[] leftList = new int[middle - left + 1];
        int[] rightList = new int[right - middle];

        // copy numList into the temporary arrays
        for (int index = 0; index < leftList.length; index++) {
            leftList[index] = numList[left + index];
        }

        for (int index = 0; index < rightList.length; index++) {
            rightList[index] = numList[middle + index + 1];
        }

        // current indexes of temporary arrays
        int leftIndex = 0;
        int rightIndex = 0;

        // copy from leftList and rightList back into numList
        for (int index = left; index <= right; index++) {
            // if there are still uncopied values in leftList and rightList, copy the smallest value of the two
            if (leftIndex < leftList.length && rightIndex < rightList.length) {
                if (leftList[leftIndex] < rightList[rightIndex]) {
                    numList[index] = leftList[leftIndex];
                    leftIndex++;
                }
                else {
                    numList[index] = rightList[rightIndex];
                    rightIndex++;
                }
            }
            else if (leftIndex < leftList.length) {
                // if all values have been copied from rightList, copy the rest of leftList
                numList[index] = leftList[leftIndex];
                leftIndex++;
            }
            else if (rightIndex < rightList.length) {
                // if all values have been copied from leftList, copy the rest of rightList
                numList[index] = rightList[rightIndex];
                rightIndex++;
            }
        }
    }

    public ArrayList<Integer> sort(ArrayList<Integer> intArrayList, int left, int right){
        int[] intArray = integerArrayListToIntArray(intArrayList);
        mergeSort(intArray, left, right);
        return intArrayToIntegerArrayList(intArray);
    }
}