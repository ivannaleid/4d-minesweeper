import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// DONE
// make digging work again, I don't know what broke it - done
// make digging more closely resemble how google minesweeper works (so that digging a non-zero cell just opens that cell) - done
// fix coordinate system (e.g. 1144 shows as 1414) - done
// test to see if the dimensions are formatted correctly - done
// make flagging work - done
// make digging un-flag cell if it was dug - done


// TO DO
// check if total mines is ≤ total cells
//
// fix adjacencies
// add an optional clear all adjacent non mines if cells adjacencies are equivalent to the number of flags around it
// add comments
// test previous fixes

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // gets the users wanted dimensions for the board
        System.out.print("Enter the 1d size (1≤x≤9): ");
        int width = scanner.nextInt();
//        int height = 3;
        System.out.print("Enter the 2d size (1≤x≤9): ");
        int height = scanner.nextInt();
//        int depth = 3;
        System.out.print("Enter the 3d size (1≤x≤9): ");
        int depth = scanner.nextInt();
//        int width = 3;
        System.out.print("Enter the 4d size (1≤x≤9): ");
        int layer = scanner.nextInt();
//        int layer = 3;
        //recommended max mines
        int maxMines = layer*depth*height*width;
        int recommendedMax = (int) (maxMines * 0.175);
        int numMines = 0;
        boolean isHigherThanMax = true;
        System.out.print("Enter the number of mines wanted(max of: " + maxMines + ", recommended amount: " + recommendedMax + "): ");
        numMines = scanner.nextInt();
        Board board = new Board(layer, height, depth, width, numMines);
        System.out.print(board);
//        System.out.println(board.toExposedString());

        //checks if the player has won or lost and responds accordingly
        while (!board.hasWon()){
            //call nextMove
            if (!nextMove(board)){
                System.out.println("You Lose");
                System.out.println(board.toExposedString());
                return;
            }
            System.out.println(board);
        }
        if (board.hasWon()){
            System.out.println("You Win");
        }

    }

    // prompts the user for their next move (digging, flagging, or checking adjacent cells of a certain cell)
    public static boolean nextMove(Board board){
        //prompt user to flag/un flag or dig a cell
        //return true if they did not dig a mine return false if they did
        Scanner scanner = new Scanner(System.in);
        System.out.println("input your move ex: '0101 F' to flag, '0101 D' to dig, '0101 S' to show the cell adjacencies");
        String input = scanner.nextLine();
        // not sure how this works but it does
        String pattern = "^([0-" + board.getLayer() + "])([0-" + board.getHeight() + "])([0-" + board.getDepth() + "])([0-" + board.getWidth() + "]) ([FDS])$";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(input);
        if (matcher.find()){
            int layer = Integer.parseInt(matcher.group(1));
            int height = Integer.parseInt(matcher.group(2));
            int depth = Integer.parseInt(matcher.group(3));
            int width = Integer.parseInt(matcher.group(4));
            String action = matcher.group(5);
            // checks the action the player inputted and does the requested action
            if (action.equals("F")){
                System.out.println("flagging " + layer + height + depth + width);
                board.toggleFlagged(layer, height, depth, width);
            } else if (action.equals("D")){
                System.out.println("digging " + layer + height + depth + width);
                if (!board.dig(layer, depth, height, width)){
                    return false;
                }
            } else {
                System.out.println("revealing adjacencies " + + layer + depth + height + width);
                // not sure why height and depth need to be swapped here, but it works and im too scared to try to fix it
                board.showAdjacent(layer, height, depth, width);
            }
        } else {
            System.out.println("bad move input must be valid cell and action");
        }

        return true;
    }
}