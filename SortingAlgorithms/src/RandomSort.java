import java.util.ArrayList;
import java.util.Random;
// returns 1 random element from the array
// 1, 3, 5, 2, 4
// random item from array
public class RandomSort extends BaseSort {
    public int sort(ArrayList<Integer> toSort){
        Random random = new Random();
        int sorted = random.nextInt(toSort.size());
        return sorted;
    }
}