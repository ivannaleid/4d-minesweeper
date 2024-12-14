import java.util.Collections;
import java.util.ArrayList;
//Doesn't sort but helps every other sorting algorithm work
// Collections.shuffle(array);
public class BaseSort {
    ArrayList<Integer> toSort = new ArrayList<>();

    public ArrayList<Integer> getRandomizedArray(){
        return toSort;
    }

    public ArrayList<Integer> createArray(int amount){
        for(int index = 1; index <= amount; index++) {
            toSort.add(index);
        }
        Collections.shuffle(toSort);
        return toSort;
    }

    public ArrayList<Integer> resetArray(ArrayList<Integer> toOverride, ArrayList<Integer> overrider){
        toOverride.clear();
        toOverride.addAll(overrider);
        return toOverride;
    }

    public int[] integerArrayListToIntArray(ArrayList<Integer> intArrayList){
        int[] intArray = new int[intArrayList.size()];
        for (int i = 0; i < intArrayList.size(); i++) {
            intArray[i] = intArrayList.get(i);
        }
        return intArray;
    }

    public ArrayList<Integer> intArrayToIntegerArrayList(int[] intArray){
        ArrayList<Integer> integerArrayList = new ArrayList<>(intArray.length);
        for(int i: intArray){
            integerArrayList.add(i);
        }
        return integerArrayList;
    }
}
