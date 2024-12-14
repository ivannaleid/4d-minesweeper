import java.util.ArrayList;
// destroys every thing that isn't already sorted
// 1, 3, 5, 2, 4
// 1, 3, 5
public class StalinSort extends BaseSort {
    public ArrayList<Integer> sort(ArrayList<Integer> toSort){
        for (int i = 0; i < toSort.size() - 1; i++) {
            int currentElement = toSort.get(i);
            int nextElement = toSort.get(i + 1);

            if (currentElement > nextElement) {
                toSort.remove(i + 1);
                i--;
            }

        }

        return toSort;
    }

}