import java.util.ArrayList;

//Adds one to the next item until it is larger than the prior one
// 1, 3, 5, 2, 4
// 1, 3, 5, 6, 7
public class AddingSort extends BaseSort {
    public ArrayList<Integer> sort(ArrayList<Integer> toSort){
        for (int i = 0; i < toSort.size() - 1; i++) {
            int currentElement = toSort.get(i);
            int nextElement = toSort.get(i + 1);

            if (currentElement >= nextElement) {
                toSort.set(i + 1, currentElement + 1);
            }

        }

        return toSort;
    }

}