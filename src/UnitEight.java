import java.util.ArrayList;
public class UnitEight {
    public static void main(String[] args) {
        int[][] values = {{1, 2, 3, 4},
                         {5, 6, 7, 8},
                         {9, 10, 11, 12}};

    }

    public static ArrayList<Integer> intArrayToIntegerArrayList(int[] intArray){
        ArrayList<Integer> integerArrayList = new ArrayList<>(intArray.length);
        for(int i: intArray){
            integerArrayList.add(i);
        }
        return integerArrayList;
    }

}
