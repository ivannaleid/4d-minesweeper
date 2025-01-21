import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        PlayMP3 sound = new PlayMP3();
        sound.playSound("explosion");
        Thread.sleep(1000);
        // gets the users wanted dimensions for the board
        System.out.print("Enter the 1d size (1≤x≤9): ");
        int width = scanner.nextInt();
        sound.playSound("action");
        System.out.print("Enter the 2d size (1≤x≤9): ");
        int height = scanner.nextInt();
        sound.playSound("action");
        System.out.print("Enter the 3d size (1≤x≤9): ");
        int depth = scanner.nextInt();
        sound.playSound("action");
        System.out.print("Enter the 4d size (1≤x≤9): ");
        int layer = scanner.nextInt();
        sound.playSound("action");
        //recommended max mines
        int maxMines = layer*depth*height*width;
        int recommendedMax = (int) (maxMines * 0.175);
        int numMines;
        System.out.print("Enter the number of mines wanted(max of: " + maxMines + ", recommended amount: " + recommendedMax + "): ");
        numMines = scanner.nextInt();
        sound.playSound("action");
        Board board = new Board(layer, height, depth, width, numMines);
        System.out.print(board);

        //checks if the player has won or lost and responds accordingly
        while (!board.hasWon()){
            //call nextMove
            if (!nextMove(board)){
                //plays the explosion sound to signify that you lost, and prints that you lost in ascii art to make it more impactful
                sound.playSound("explosion");
                System.out.println("__  __               __                   \n" +
                        "\\ \\/ /___  __  __   / /   ____  ________  \n" +
                        " \\  / __ \\/ / / /  / /   / __ \\/ ___/ _ \\ \n" +
                        " / / /_/ / /_/ /  / /___/ /_/ (__  )  __/ \n" +
                        "/_/\\____/\\__,_/  /_____/\\____/____/\\___(_)\n" +
                        "                                          ");
                System.out.println(board.toExposedString());
                return;
            }
            System.out.println(board);
        }
        if (board.hasWon()){
            //prints that you won in ascii art
            System.out.println("__  __               _       ___       __\n" +
                    "\\ \\/ /___  __  __   | |     / (_)___  / /\n" +
                    " \\  / __ \\/ / / /   | | /| / / / __ \\/ / \n" +
                    " / / /_/ / /_/ /    | |/ |/ / / / / /_/  \n" +
                    "/_/\\____/\\__,_/     |__/|__/_/_/ /_(_)   \n" +
                    "                                         ");
        }

    }

    // prompts the user for their next move (digging, flagging, or checking adjacent cells of a certain cell)
    public static boolean nextMove(Board board){
        PlayMP3 sound = new PlayMP3();
        sound.playSound("action");

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
                System.out.println("revealing adjacencies " + + layer + height + depth† + width);
                // not sure why height and depth need to be swapped here, but it works and im too scared to try to fix it
                board.showAdjacent(layer, depth, height, width);
            }
        } else {
            System.out.println("bad move input must be valid cell and action");
        }

        return true;
    }
}