package minesweeper4d;

import java.util.Random;
public class Board{

    private int height;
    private int width;
    private int depth;
    private int layer;

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getDepth() {
        return depth;
    }

    public int getLayer() {
        return layer;
    }
    private int numMines;
    private Cell[][][][] board;
    Random rand = new Random();

    public Board(int layer, int depth, int height, int width, int numMines){
        this.layer = layer;
        this.depth = depth;
        this.height = height;
        this.width = width;
        this.numMines = numMines;
        this.board = generate4dBoard();
    }

    public void toggleFlagged(int layer, int height, int depth, int width){
        Cell cell = board[layer][depth][height][width];
        cell.setFlagged(!cell.isFlagged());
    }

    public void showAdjacent(int layer, int depth, int height, int width){
        int[] directions = {-1, 0, 1};
        for (int layerDirections : directions){
            for (int depthDirections : directions){
                for (int heightDirections : directions) {
                    for (int widthDirections : directions){
                        int adjacentLayer = layer + layerDirections;
                        if(adjacentLayer < 0 || adjacentLayer >= this.layer){
                            continue;
                        }
                        int adjacentDepth = depth + depthDirections;
                        if(adjacentDepth < 0 || adjacentDepth >= this.depth){
                            continue;
                        }
                        int adjacentHeight = height + heightDirections;
                        if(adjacentHeight < 0 || adjacentHeight >= this.height){
                            continue;
                        }
                        int adjacentWidth = width + widthDirections;
                        if(adjacentWidth < 0 || adjacentWidth >= this.width){
                            continue;
                        }
                        Cell adjacentCell = board[adjacentLayer][adjacentDepth][adjacentHeight][adjacentWidth];
                        if (!adjacentCell.isVisible && !adjacentCell.isFlagged){
                            if (layerDirections - heightDirections == 1 || layerDirections - heightDirections == -1){
                                adjacentCell.setShowingAdjacencies(true);
                            }
                            if(layerDirections == 0 && heightDirections == 0){
                                adjacentCell.setShowingAdjacencies(true);
                            }
                        }
                    }
                }
            }
        }
    }

    // add initial move
    public Cell[][][][] generate4dBoard(){
        //create the board
        Cell[][][][] board = new Cell[layer][depth][height][width];
        for (int layer = 0; layer < board.length; layer++) {
            for (int depth = 0; depth < board[layer].length; depth++) {
                for (int height = 0; height < board[layer][depth].length; height++){
                    for (int width = 0; width < board[layer][depth][height].length; width++){
                        board[layer][depth][height][width] = new Cell(layer, depth, height, width);
                    }
                }
            }
        }
        //allocate mines to cells
        for (int i = 0; i < numMines; i++) {
            int randomLayer = rand.nextInt(board.length);
            int randomDepth = rand.nextInt(board[randomLayer].length);
            int randomHeight = rand.nextInt(board[randomLayer][randomDepth].length);
            int randomWidth = rand.nextInt(board[randomLayer][randomDepth][randomHeight].length);
            if (board[randomLayer][randomDepth][randomHeight][randomWidth].isMine()){
                i--; // decrement because this loop didn't find a place to put a mine
            } else { // could do a different thing in addition to generating 100 boards to guarantee if throughout all 100 of those generations that there will still be a rectangle of 0s where you first dug
                board[randomLayer][randomDepth][randomHeight][randomWidth].setMine(true);
            }
        }
        for (int layer = 0; layer < board.length; layer++) {
            for (int depth = 0; depth < board[layer].length; depth++) {
                for (int height = 0; height < board[layer][depth].length; height++){
                    for (int width = 0; width < board[layer][depth][height].length; width++){
                        int adjacentMines = countAdjacentMines(board, layer, depth, height, width);
                        board[layer][depth][height][width].setAdjacentMines(adjacentMines);
                    }
                }
            }
        }
        return board;
    }

    public String toString() {
        StringBuilder printedBoard = new StringBuilder();
        for (int layer = 0; layer < board.length; layer++) {
            for (int depth = 0; depth < board[layer].length; depth++) {
                for (int height = 0; height < board[layer][depth].length; height++){
                    for (int width = 0; width < board[layer][depth][height].length; width++){
                        printedBoard.append(board[layer][depth][height][width].toString());
                    }
                    printedBoard.append("   ");
                }
                printedBoard.append("\n");
            }
            printedBoard.append("\n");
        }
        return printedBoard.toString();
    }

    public String toExposedString() {
        StringBuilder printedBoard = new StringBuilder();
        for (int layer = 0; layer < board.length; layer++) {
            for (int depth = 0; depth < board[layer].length; depth++) {
                for (int height = 0; height < board[layer][depth].length; height++){
                    for (int width = 0; width < board[layer][depth][height].length; width++){
                        printedBoard.append(board[layer][depth][height][width].toExposedString()).append(" ");
                    }
                    printedBoard.append("   ");
                }
                printedBoard.append("\n");
            }
            printedBoard.append("\n");
        }
        return printedBoard.toString();
    }

    private int countAdjacentMines(Cell[][][][] board, int layer, int depth, int height, int width){
        int adjacentMines = 0;
        int[] directions = {-1, 0, 1};
        for (int layerDirections : directions){
            for (int depthDirections : directions){
                for (int heightDirections : directions){
                    for (int widthDirections : directions){
                        int adjacentLayer = layer + layerDirections;
                        if(adjacentLayer < 0 || adjacentLayer >= this.layer){
                            continue;
                        }
                        int adjacentDepth = depth + depthDirections;
                        if(adjacentDepth < 0 || adjacentDepth >= this.depth){
                            continue;
                        }
                        int adjacentHeight = height + heightDirections;
                        if(adjacentHeight < 0 || adjacentHeight >= this.height){
                            continue;
                        }
                        int adjacentWidth = width + widthDirections;
                        if(adjacentWidth < 0 || adjacentWidth >= this.width){
                            continue;
                        }
                        if (board[adjacentLayer][adjacentDepth][adjacentHeight][adjacentWidth].isMine){
                            if (layerDirections - heightDirections == 1 || layerDirections - heightDirections == -1){
                                adjacentMines++;
                            }
                            if(layerDirections == 0 && heightDirections == 0){
                                adjacentMines++;
                            }
                        }
                    }
                }
            }
        }
        return adjacentMines;
    }


    public boolean hasWon(){
        for (int layer = 0; layer < board.length; layer++) {
            for (int depth = 0; depth < board[layer].length; depth++) {
                for (int height = 0; height < board[layer][depth].length; height++){
                    for (int width = 0; width < board[layer][depth][height].length; width++){
                        Cell cell = board[layer][depth][height][width];
                        // checks all cells to ensure that they are visible if they arent mines
                        if (!cell.isMine && !cell.isVisible){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
    // returns false if a mine was dug
    public boolean dig(int layer, int depth, int height, int width) {
        Cell cell = board[layer][depth][height][width];
        cell.setVisible(true);
        if (cell.isMine){
            return false;
        }
        int[] directions = {-1, 0, 1};
        for (int layerDirections : directions){
            for (int depthDirections : directions){
                for (int heightDirections : directions){
                    for (int widthDirections : directions){
                        int adjacentLayer = layer + layerDirections;
                        if(adjacentLayer < 0 || adjacentLayer >= this.layer){
                            continue;
                        }
                        int adjacentDepth = depth + depthDirections;
                        if(adjacentDepth < 0 || adjacentDepth >= this.depth){
                            continue;
                        }
                        int adjacentHeight = height + heightDirections;
                        if(adjacentHeight < 0 || adjacentHeight >= this.height){
                            continue;
                        }
                        int adjacentWidth = width + widthDirections;
                        if(adjacentWidth < 0 || adjacentWidth >= this.width){
                            continue;
                        }
                        Cell  adjacentCell = board[adjacentLayer][adjacentDepth][adjacentHeight][adjacentWidth];
                        if (!adjacentCell.isVisible && !adjacentCell.isFlagged){
                            if (layerDirections - heightDirections == 1 || layerDirections - heightDirections == -1){
                                if (cell.getExposedStatus().equals("00")){
                                    this.dig(adjacentLayer, adjacentDepth, adjacentHeight, adjacentWidth);
                                    adjacentCell.setVisible(true);
                                } else {
                                    cell.setVisible(true);
                                    if (adjacentCell.getExposedStatus().equals("00")){
                                        cell.setVisible(true);
                                    }
                                }
                            }
                            if(layerDirections == 0 && heightDirections == 0){
                                if (cell.getExposedStatus().equals("00")){
                                    this.dig(adjacentLayer, adjacentDepth, adjacentHeight, adjacentWidth);
                                    adjacentCell.setVisible(true);
                                } else {
                                    cell.setVisible(true);
                                    if (adjacentCell.getExposedStatus().equals("00")){
                                        cell.setVisible(true);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
