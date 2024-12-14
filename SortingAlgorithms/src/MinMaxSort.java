import java.util.ArrayList;
import java.util.Collections;
// finds the smallest element in an array list and the largest and creates an array from those two points
// 1, 3, 5, 2, 4
// 1, 2, 3, 4, 5
// requires the starting array to have every number between the smallest and the largest
// and cannot have repeating numbers

public class MinMaxSort {
    public ArrayList<Integer> sort(ArrayList<Integer> toSort){
        int max = Collections.max(toSort);
        int min = Collections.min(toSort);

        ArrayList<Integer> sorted = new ArrayList<>();
        for(int i = min; i <= max; i++){
            sorted.add(i);
        }
        return sorted;
    }
}
