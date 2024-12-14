import java.util.ArrayList;
import java.util.Scanner;

// makes you manually sort the array, and checks to see if you put it in wrong
// 1, 3, 5, 2, 4
// 1, 2, 3, 4, 5
public class ManualSort extends SelectionSort {
    public boolean checkCorrect(ArrayList<Integer> input, ArrayList<Integer> correctSort){
        if (input.equals(correctSort)) {
            return true;
        }
        return false;
    }


    public ArrayList<Integer> sort(ArrayList<Integer> toSort){
        Scanner scanner = new Scanner(System.in);
        SelectionSort selection = new SelectionSort();
        ArrayList<Integer> input = new ArrayList<>();
        ArrayList<Integer> correctSort = selection.sort(toSort);
        boolean isCorrect = false;
        System.out.println("Manual Sort:");

        while (!isCorrect){
            for(int i = 0; i < toSort.size(); i++){
                System.out.println("index " + i + ": ");
                int inputNum = scanner.nextInt();
                input.add(inputNum);
            }
            if(checkCorrect(input, correctSort) != true){
                System.out.println("That was not correct");
                sort(toSort);
            } else {
                isCorrect = true;
            }
        }

        return input;
    }

}